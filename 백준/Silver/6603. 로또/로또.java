import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

  /*
   * 
   */

  static int N;
  static int[] target;
  static int[] arr;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // Scanner sc = new Scanner(System.in);
    // StringTokenizer st = new StringTokenizer(br.readLine());
    while (true) {

      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());

      if (N == 0) {
        break;
      }

      arr = new int[N];
      target = new int[6];
      visited = new boolean[N];
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      dfs(0, 0);
      System.out.println();
    }

  }

  static void dfs(int start, int depth) {
    if (depth == 6) {
      for (int i : target) {
        System.out.print(i + " ");
      }
      System.out.println();
      return;
    }

    for (int i = start; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        target[depth] = arr[i];
        dfs(i, depth + 1);
        visited[i] = false;
      }
    }
  }

}
