import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};

        // String string = s.replace('}', ' ');

        String str = s.replaceAll("[^0-9,]", "");

        String[] strArr = str.split(",");

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < strArr.length; i++) {
            int target = Integer.parseInt(strArr[i]);
            map.put(target, map.getOrDefault(target, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> map.get(o2) - map.get(o1));

        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;

    }

}