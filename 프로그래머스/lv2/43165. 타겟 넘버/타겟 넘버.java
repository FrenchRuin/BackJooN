import java.util.*;

class Solution {

    static int answer = 0;

    public int solution(int[] numbers, int target) {

        dfs(numbers, 0, target, 0);

        return answer;
    }

    public void dfs(int[] numbers, int depth, int target, int sum) {
        // 만약 모두 돌았다면
        if (depth == numbers.length) {
            // sum과 target이 같다면
            if (sum == target) {
                answer++;
            }
        } else { // 모두 돌지 않았다면?
                 // + 일경우와 -일경우 모두 돌아준다.
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }
}
