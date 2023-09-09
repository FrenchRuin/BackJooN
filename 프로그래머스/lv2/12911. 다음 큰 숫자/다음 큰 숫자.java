import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        String s = Integer.toBinaryString(n);

        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                one++;
        }

        while (true) {
            n++;
            int onex = 0;
            String x = Integer.toBinaryString(n);
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) == '1')
                    onex++;
            }

            if (one == onex) {
                answer = n;
                break;
            }
        }

        return answer;
    }
}