import java.util.*;

class Solution {
    public String solution(String phone_number) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        String[] pn = phone_number.split("");

        for (int i = 0; i < pn.length; i++) {

            if (i >= pn.length - 4) {
                sb.append(pn[i]);
            }else{
                sb.append("*");
            }
        }
        answer = sb.toString();
        return answer;
    }
}