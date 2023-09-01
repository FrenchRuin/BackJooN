import java.util.*;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;

        String nn = String.valueOf(x);

        String[] dd = nn.split("");

        int sum = 0;
        for (int i = 0; i < dd.length; i++) {
            sum += Integer.parseInt(dd[i]);
        }

        if(x % sum == 0) answer = true;
        else answer = false;

        return answer;
    }
}