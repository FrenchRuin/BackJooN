import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

  /*
   * 
   */

  static int N;
  static int[] arr;
  static int[] target;
  static boolean[] visited;
  static int aa;

  public static void main(String[] args) throws IOException {

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    // StringTokenizer st = new StringTokenizer(br.readLine());
    N = sc.nextInt();

    arr = new int[N];
    target = new int[N];
    visited = new boolean[N];

    // 배열입력
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);

    recur(0);

    System.out.println(aa);

  }

  static void recur(int depth) {

    if (depth == N) {
      int sum = 0;
      for (int i = 1; i < N; i++) {
        sum += Math.abs(target[i - 1] - target[i]);
      }
      aa = Math.max(aa, sum);
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        target[depth] = arr[i];
        recur(depth + 1);
        visited[i] = false;
      }
    }

  }

}
