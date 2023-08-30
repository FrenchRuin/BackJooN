import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> tmpMap = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            if (tmpMap.containsKey(participant[i])) {
                Integer nn = tmpMap.get(participant[i]);
                tmpMap.remove(participant[i]);
                tmpMap.put(participant[i], nn + 1);
            } else {
                tmpMap.put(participant[i], 1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            if (tmpMap.containsKey(completion[i])) {
                Integer nn = tmpMap.get(completion[i]);
                tmpMap.remove(completion[i]);
                tmpMap.put(completion[i], nn - 1);
            }
        }

        for (int i = 0; i < participant.length; i++) {
            if (tmpMap.get(participant[i]) > 0) {
                answer = participant[i];
            }
        }

        return answer;
    }
}