import java.util.*;
import java.io.*;

public class Main {

  /*
   * 
   */
  static int M;
  static int N;
  static boolean[] visited;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // ex) 3
    M = Integer.parseInt(st.nextToken()); // ex) 1

    visited = new boolean[N];
    arr = new int[M];

    recur(0, 0);

    System.out.println(sb);
  }

  static void recur(int idx, int depth) {
    if (depth == M) {
      for (int i : arr) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = idx; i < N; i++) {
      if (!visited[i]) { // 방문하지않은 곳이라면
        visited[i] = true;
        arr[depth] = i + 1;
        recur(i, depth + 1);
        visited[i] = false;
      }
    }
  }
}
