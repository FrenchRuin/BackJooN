import java.util.*;
import java.io.*;

public class Main {

  /*
   * 
   */
  static int M;
  static int N;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // ex) 3
    M = Integer.parseInt(st.nextToken()); // ex) 1

    arr = new int[M];

    recur(1, 0);

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

    for (int i = idx; i <= N; i++) {
      arr[depth] = i;
      recur(i, depth + 1);
    }
  }
}
