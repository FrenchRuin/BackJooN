import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int dif = 100 - progresses[i];
            int speed = speeds[i];

            if (dif % speed == 0) {
                queue.add(dif / speed);
            } else {
                queue.add((dif / speed) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int cnt = 1;

            int work = queue.poll();

            while (!queue.isEmpty() && work >= queue.peek()) {
                cnt++;
                queue.poll();
            }

            list.add(cnt);
        }

        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}