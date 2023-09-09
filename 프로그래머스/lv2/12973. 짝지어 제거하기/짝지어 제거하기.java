import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = -1;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek().equals(s.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        answer = stack.isEmpty() ? 1 : 0;

        return answer;
    }
}