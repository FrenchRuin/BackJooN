import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        List<String> strList = new ArrayList<>();

        strList.add(words[0]);
        int now = 0;
        answer[0] = 1;
        answer[1] = 1;
        boolean chk = true;
        for (int i = 1; i < words.length; i++) {

            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1) || strList.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                chk = false;
                break;
            }
            strList.add(words[i]);

        }
        if (chk) {
            answer[0] = 0;
            answer[1] = 0;
        }

        System.out.println(now);

        return answer;
    }
}