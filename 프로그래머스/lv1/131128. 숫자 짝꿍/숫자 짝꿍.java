import java.util.*;

class Solution {
    public String solution(String X, String Y) {

        StringBuilder answer = new StringBuilder();

        int[] xarr = new int[10];
        int[] yarr = new int[10];

        for (String s : X.split("")) {
            xarr[Integer.parseInt(s)]++;
        }

        for (String s : Y.split("")) {
            yarr[Integer.parseInt(s)]++;
        }

        for (int i = 9; i >= 0; i--) {
            while(xarr[i] > 0 && yarr[i] > 0){
                answer.append(i);

                xarr[i]--;
                yarr[i]--;
            }
        }

        if("".equals(answer.toString())) return "-1";

        if("0".equals(answer.toString().substring(0, 1))) return "0";

        return answer.toString();
    }
}