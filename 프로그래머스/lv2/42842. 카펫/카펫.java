import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for (int i = 1; i <= sum; i++) {
            int col = i;
            int row = sum / col;

            if (col > row)
                continue;

            if ((row - 2) * (col - 2) == yellow) {
                answer[0] = row;
                answer[1] = col;
                break;
            }
        }

        return answer;
    }
}