import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }

        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], 0);
        }

        for (int i = 0; i < 10; i++) {
            if(map.get(i) != 0){
                answer += map.get(i);
            }
        }

        return answer;
    }
}