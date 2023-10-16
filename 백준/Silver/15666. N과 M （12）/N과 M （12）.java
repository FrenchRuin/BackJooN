import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

  /*
   * 
   */
  static int M;
  static int N;
  static int[] arr;
  static int[] answer;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // StringTokenizer st = new StringTokenizer(br.readLine());

    // N = Integer.parseInt(st.nextToken()); // ex) 3
    // M = Integer.parseInt(st.nextToken()); // ex) 1

    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();

    arr = new int[N];
    answer = new int[M];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);

    recur(0, 0);

    System.out.println(sb);
  }

  static void recur(int idx, int depth) {
    if (depth == M) {
      for (int i : answer) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }
    int before = 0;
    for (int i = idx; i < N; i++) {

      if (before != arr[i]) {
        answer[depth] = arr[i];
        before = arr[i];
        recur(i, depth + 1);
      }
    }
  }
}
