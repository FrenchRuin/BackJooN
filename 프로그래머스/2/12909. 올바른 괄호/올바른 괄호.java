import java.util.*;

class Solution {
  boolean solution(String s) {
    boolean answer = true;

    Stack<Character> stack = new Stack<>();

    int N = s.length();

    for (int i = 0; i < N; i++) {
      if (s.charAt(i) == '(') {
        stack.push('(');
      } else if (s.charAt(i) == ')') {
        if (stack.isEmpty()) {
          return false;
        }
        stack.pop();
      }
    }

    if (!stack.isEmpty())
      return false;

    return answer;
  }
}