import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

  /*
   * 
   */

  static int N;
  static int[] arr;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    // StringTokenizer st = new StringTokenizer(br.readLine());
    N = sc.nextInt();

    arr = new int[N];
    visited = new boolean[N];

    recur(0);

    System.out.println(sb);

  }

  static void recur(int depth) {

    if (depth == N) {
      for (int i : arr) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[depth] = i + 1;
        recur(depth + 1);
        visited[i] = false;
      }
    }

  }

}
