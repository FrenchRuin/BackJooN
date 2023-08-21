import java.util.*;

class Solution {
    public int solution(String t, String p) throws Exception {
        int answer = 0;

        Long pN = Long.parseLong(p);
        int pL = p.length(); // 

        for (int i = 0; i < t.length() - pL + 1; i++) {
            Long df = Long.parseLong(t.substring(i, pL + i));

            if( df <= pN) answer ++;
        }
        return answer;
    }
}