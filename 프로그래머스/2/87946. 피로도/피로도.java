import java.util.*;

class Solution {

  static boolean[] visited;
  static int answer;

  public int solution(int k, int[][] dungeons) {
    answer = 0;
    visited = new boolean[dungeons.length];

    return dfs(dungeons, k, visited, 0);
  }

  static int dfs(int[][] dungeons, int k, boolean[] visited, int cnt) {

    for (int i = 0; i < dungeons.length; i++) {
      if (!visited[i] && dungeons[i][0] <= k) {
        visited[i] = true;
        dfs(dungeons, k - dungeons[i][1], visited, cnt + 1);
        visited[i] = false;
      }
    }

    answer = Math.max(answer, cnt);

    return answer;
  }
}