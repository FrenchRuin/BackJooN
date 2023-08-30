import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        Arrays.sort(numbers);

        Set<Integer> tmpSet = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                tmpSet.add(numbers[i] + numbers[j]);
            }
        }

        Iterator<Integer> nn = tmpSet.iterator();

        int[] answer = new int[tmpSet.size()];

        for (int i = 0; i < tmpSet.size(); i++) {
            answer[i] = nn.next();
        }

        Arrays.sort(answer);

        return answer;
    }
}