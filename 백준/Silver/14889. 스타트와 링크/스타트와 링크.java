import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

  /*
   * 
   */

  static int N;
  static int[][] people;
  static boolean[] visited;

  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // Scanner sc = new Scanner(System.in);
    // StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(br.readLine());
    people = new int[N][N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        people[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dfs(0, 0);

    System.out.println(min);
  }

  static void dfs(int idx, int count) {
    if (count == N / 2) {
      // 방문한팀과 아닌팀을 나누어 점수를 구한뒤 최솟값 ㄱㄱ
      int start = 0;
      int link = 0;

      for (int i = 0; i < N - 1; i++) {
        for (int j = i + 1; j < N; j++) {
          if (visited[i] && visited[j]) {
            start += people[i][j];
            start += people[j][i];
          } else if (!visited[i] && !visited[j]) {
            link += people[i][j];
            link += people[j][i];
          }
        }
      }

      int value = Math.abs(start - link);

      if (value == 0) {
        System.out.println(0);
        System.exit(0);
      }
      min = Math.min(value, min);
      return;
    }

    for (int i = idx; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(i + 1, count + 1);
        visited[i] = false;
      }
    }

  }

}
