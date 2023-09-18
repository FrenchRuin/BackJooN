import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        List<String> listStr1 = new ArrayList<>();
        List<String> listStr2 = new ArrayList<>();
        List<String> interaction = new ArrayList<>();
        List<String> union = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length() - 1; i++) {
            char front = str1.charAt(i);
            char back = str1.charAt(i + 1);
            if (front >= 'a' && front <= 'z' && back >= 'a' && back <= 'z') {
                listStr1.add(front + "" + back);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char front = str2.charAt(i);
            char back = str2.charAt(i + 1);
            if (front >= 'a' && front <= 'z' && back >= 'a' && back <= 'z') {
                listStr2.add(front + "" + back);
            }
        }

        Collections.sort(listStr1);
        Collections.sort(listStr2);

        for (String string : listStr1) {
            if (listStr2.remove(string)) {
                interaction.add(string);
            }

            union.add(string);
        }

        for (String string : listStr2) {
            union.add(string);
        }

        double ans = 0;

        if (union.size() == 0) {
            ans = 1;
        } else {
            ans = (double) interaction.size() / (double) union.size();
        }

        answer = (int) (ans * 65536);

        return answer;
    }
}