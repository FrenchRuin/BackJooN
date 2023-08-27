import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int str = commands[i][0];
            int end = commands[i][1];
            int target = commands[i][2];

            int[] tmp = new int[end - str + 1];
            int idx = 0;
            for (int j = str - 1; j <= end - 1; j++) {

                tmp[idx] = array[j];

                idx++;
            }
            Arrays.sort(tmp);
            answer[i] = tmp[target - 1];
        }

        return answer;
    }
}