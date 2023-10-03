import java.util.*;
import java.io.*;

public class Main {

  /*
   * 다이나믹 프로그래밍 dp 연속합이다.
   * 
   * 10 -4 3 1 5 6 -35 12 21 -1
   * 해당 인덱스에서 처음부터 반복하면서 최대값을 저장 시킨후,
   * 최대값을 가져오면 답이 되지 않을까??
   * 
   * 이중 for문 시간초과
   * 100,000 * 100,000 = 백억
   * 
   */

  static int[] dp;
  static int[] arr;
  static int N;

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    arr = new int[N];
    dp = new int[N];

    // arr value insert
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    dp[0] = arr[0];
    int max = arr[0];

    for (int i = 1; i < N; i++) {
      dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);

      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}
