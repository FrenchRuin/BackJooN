import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;

        int[] ele = new int[elements.length * 2];

        for (int i = 0; i < elements.length; i++) {
            ele[i] = ele[i + elements.length] = elements[i];
        }

        Set<Integer> Hset = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = i; j < i + elements.length; j++) {
                sum += ele[j];
                Hset.add(sum);
            }
        }

        answer = Hset.size();
        return answer;
    }
}