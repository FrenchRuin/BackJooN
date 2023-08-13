import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        int tmp = 0;

        char first = s.charAt(0);

        for (int i = 0; i < s.toCharArray().length; i++) {

            if (tmp == 0) {
                first = s.charAt(i);
            }

            if (s.charAt(i) == first) {
                tmp ++;
            }else{
                tmp --;
            }

            if (tmp == 0 || i == s.toCharArray().length - 1) {
                answer++;
            }
        }
        return answer;
    }
}