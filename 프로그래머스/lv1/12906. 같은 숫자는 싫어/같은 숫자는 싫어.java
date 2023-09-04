import java.util.*;

public class Solution {
public int[] solution(int[] arr) {

        Stack<Integer> st = new Stack<>();

        for (int i : arr) {
            if (st.empty()) {
                st.push(i);
            } else {
                if (!st.peek().equals(i)) {
                    st.push(i);
                    
                }
            }
            
        }

        int[] answer = new int[st.size()];

          for (int i = answer.length- 1 ; i > -1; i--) {
            answer[i] = st.peek();
            st.pop();
        }
        return answer;
    }
}