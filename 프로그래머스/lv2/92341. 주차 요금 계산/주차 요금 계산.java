import java.util.*;

/*
 * 차번호 , 시간 Map<String, Integer>
 * 
 * 차번호, 누적요금 Map<String, Integer > treemap
 * 
 */
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        // 차들의 주차 상태
        Map<String, Integer> parking = new HashMap<>();

        // 차번호와 누적시간 및 요금 계산 용 TreeMap으로 차번호 오름차순 정렬
        Map<String, Integer> costs = new TreeMap<>();

        for (String record : records) {
            String[] recordArr = record.split(" ");
            int time = getMm(recordArr[0]);
            String carNum = recordArr[1]; // 차번호
            String status = recordArr[2]; // 입차 출차 정보 IN OUT

            if (status.equals("IN")) {
                parking.put(carNum, time);
            }

            if (status.equals("OUT")) {
                if (!costs.containsKey(carNum)) {
                    costs.put(carNum, time - parking.get(carNum));
                } else {
                    costs.put(carNum, costs.get(carNum) + time - parking.get(carNum));
                }
                parking.remove(carNum);
            }
        }

        if (!parking.isEmpty()) {
            for (String carNum : parking.keySet()) {
                Integer cost = costs.get(carNum);
                cost = (cost == null) ? 0 : cost;
                costs.put(carNum, cost + (23 * 60 + 59) - parking.get(carNum));
            }
        }

        List<Integer> answerList = new ArrayList<>(costs.size());

        for (Integer cost : costs.values()) {
            int basicTime = fees[0];
            int basicFee = fees[1];
            int unitTime = fees[2];
            int unitFee = fees[3];

            if (cost <= basicTime) {
                answerList.add(basicFee);
            } else {
                answerList.add((int) (basicFee + Math.ceil((double) (cost - basicTime) / unitTime) * unitFee));
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    // 시간을 분으로 변경
    public static int getMm(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
}