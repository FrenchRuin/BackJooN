import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        /**
         * Set에 넣어놓고,
         * 한글자씩 때어보면서 접두어가 있는지 확인한다.
         */
        Set<String> set = new HashSet<>();

        for (String string : phone_book) {
            set.add(string);
        }

        for (String str : phone_book) {
            for (int i = 0; i < str.length(); i++) {
                if (set.contains(str.substring(0, i)))
                    return false;
            }
        }

        return true;
    }
}