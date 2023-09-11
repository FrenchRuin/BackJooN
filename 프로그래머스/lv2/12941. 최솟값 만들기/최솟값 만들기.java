import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        System.out.println("Hello Java");

        Arrays.sort(A); // A정렬
        Arrays.sort(B); // B정렬

        for (int i = 0; i < B.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }
}