import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {

        List<Long> list = new ArrayList<>();

        for (long i = left; i < right + 1; i++) {
            list.add(Math.max(i / n, i % n) + 1);
        }

        int div = (int) (right - left + 1);

        int[] answer = new int[div];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }
}