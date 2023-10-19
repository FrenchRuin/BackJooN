import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

  /*
   * 
   */

  static int N;
  static int[][] map;
  static boolean[] visited;
  static int answer;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // Scanner sc = new Scanner(System.in);
    // StringTokenizer st = new StringTokenizer(br.readLine());

    // N * N
    N = Integer.parseInt(br.readLine());

    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    answer = Integer.MAX_VALUE;
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      visited[i] = true;
      dfs(i, i, 0, 0);
    }

    System.out.println(answer);
  }

  static void dfs(int start, int now, int sum, int cnt) {
    if (cnt == N - 1) {
      if (map[now][start] != 0) {
        sum += map[now][start];
        answer = Math.min(answer, sum);
      }
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i] && map[now][i] != 0) {
        visited[i] = true;
        dfs(start, i, sum + map[now][i], cnt + 1);
        visited[i] = false;
      }
    }
  }

}
