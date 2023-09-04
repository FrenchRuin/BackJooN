import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        String[] ss = s.split("");

        if (ss.length % 2 != 0) {
            sb.append(ss[ss.length / 2]);
        } else {
            sb.append(ss[ss.length / 2 - 1]);
            sb.append(ss[ss.length / 2]);

        }

        answer = sb.toString();

        return answer;
    }
}