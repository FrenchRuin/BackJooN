import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] str = s.split(" ");

        int max = Integer.parseInt(str[0]);
        int min = Integer.parseInt(str[0]);

        for (int i = 1; i < str.length; i++) {
            max = Math.max(max, Integer.parseInt(str[i]));
            min = Math.min(min, Integer.parseInt(str[i]));
        }

        answer = String.valueOf(min) + ' ' + String.valueOf(max);
        return answer;
    }
}