import java.util.*;

class Solution {
  public int solution(int k, int m, int[] score) {
    int answer = 0;

    Integer[] temp = Arrays.stream(score).boxed().toArray(Integer[]::new);

    Arrays.sort(temp, Collections.reverseOrder());

    for (int i = 0; i < temp.length; i++) {
      if ((i + 1) % m == 0) {
        answer += temp[i] * m;
      }
    }
    return answer;
  }
}