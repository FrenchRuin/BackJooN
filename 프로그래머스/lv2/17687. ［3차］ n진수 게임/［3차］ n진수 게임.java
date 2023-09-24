import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {

        StringBuilder radix = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; radix.length() <= t * m; i++) {
            radix.append(Integer.toString(i, n));
        }

        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(radix.charAt(i));
        }

        return answer.toString().toUpperCase();
    }
}