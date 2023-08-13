import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> keyPad = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char cur = keymap[i].charAt(j);
                if (keyPad.containsKey(cur)) {
                    int idx = keyPad.get(cur);
                    keyPad.put(cur, Math.min(idx, j + 1));
                } else {
                    keyPad.put(cur, j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int cnt = 0;
            boolean flag = true;

            for (char cur : target.toCharArray()) {
                if (keyPad.containsKey(cur)) {
                    cnt += keyPad.get(cur);
                }else{
                    flag = false;
                    break;
                }
            }

            answer[i] = flag == false ? -1 : cnt;
        }
        return answer;
    }
}



