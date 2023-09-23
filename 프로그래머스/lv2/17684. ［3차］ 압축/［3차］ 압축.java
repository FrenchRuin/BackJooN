import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};

        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();

        // preSet
        char ch = 'A';
        for (int i = 0; i < 26; i++) {
            dic.put(ch + "", i + 1);
            ch += 1;
        }

        int idx = 0;
        while (idx < msg.length()) {
            String str = "";
            while (idx < msg.length()) {
                if (!dic.containsKey(str + msg.charAt(idx))) {
                    break;
                } else {
                    str += msg.charAt(idx);
                }
                idx++;
            }
            answerList.add(dic.get(str));

            if (idx < msg.length()) {
                dic.put(str + msg.charAt(idx), dic.size() + 1);
            }
        }

        answer = answerList.stream().mapToInt(Integer::valueOf).toArray();

        return answer;
    }
}
