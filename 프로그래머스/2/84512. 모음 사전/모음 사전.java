import java.util.*;

class Solution {

  static int cnt;
  static String alpa[] = new String[] { "A", "E", "I", "O", "U" };
  static int answer;

  public int solution(String word) {
    answer = 0;
    cnt = 0;

    dfs(0, alpa, "", word);
    return answer;
  }

  static void dfs(int depth, String[] alpa, String currString, String word) {
    if (depth == alpa.length) {
      return;
    }

    for (int i = 0; i < alpa.length; i++) {
      cnt++;
      String target = currString + alpa[i];
      if (target.equals(word)) {
        answer = cnt;
      }
      dfs(depth + 1, alpa, target, word);
    }
  }
}