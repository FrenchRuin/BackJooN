import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        long sum = 0;

        for (long i = 0; i < count; i++) {
            sum += (long) price * (i + 1);
        }

        if (sum - money <= 0) {
            answer = 0;
        } else {
            answer = sum - money;
        }
        return answer;
    }
}