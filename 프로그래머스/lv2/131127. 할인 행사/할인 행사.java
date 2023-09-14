import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();

        // Map에 모두 넣는다
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length; i++) {
            if (i == discount.length - 9)
                break;
            Map<String, Integer> discoutMap = new HashMap<>();
            boolean isCorrect = true;
            for (int j = i; j < i + 10; j++) {
                discoutMap.put(discount[j], discoutMap.getOrDefault(discount[j], 0) + 1);
            }

            for (int j = 0; j < wantMap.size(); j++) {
                if (wantMap.get(want[j]) != discoutMap.get(want[j])) {
                    isCorrect = false;
                    break;
                }
            }

            if (isCorrect)
                answer++;
        }
        return answer;
    }
}