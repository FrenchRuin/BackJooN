import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";

        List<Integer> lst = new ArrayList<>();

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                lst.add(i);
            }
        }

        List<Integer> ff = new ArrayList<>();
        ff.addAll(lst);
        ff.add(0);

        for (int i = lst.size() - 1; i >= 0; i--) {
            ff.add(lst.get(i));
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Integer integer : ff) {
            stringBuilder.append(integer);
        }

        answer = stringBuilder.toString();
        return answer;
    }
}