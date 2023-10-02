import java.util.*;
import java.io.*;

public class Main {

  /*
   * dp 다이나믹 프로그래밍
   * 
   * 수열 A = {10,20,10,30,20,50}
   * > 10,20,30,50 >> 4
   * >> Top-Down 방식으로 간다. 재귀
   * 
   * 10일경우, 1
   * 20 > 10,20 = 2
   * 10 > 10 = 1
   * 30 > 10,20,30 = 3
   * 20 > 10,20 =2
   * 50 > 10, 20, 30, 50 = 4
   */

  static int N;
  static Integer[] dp;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    arr = new int[N];
    dp = new Integer[N];

    // arr 값 insert
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    // 경우의수 추출
    for (int i = 0; i < N; i++) {
      LIS(i);
    }

    int answer = dp[0];
    for (int i = 1; i < N; i++) {
      answer = Math.max(answer, dp[i]);
    }

    System.out.println(answer);
  }

  static int LIS(int N) {
    // 탐색안했으면
    if (dp[N] == null) {
      dp[N] = 1;

      for (int i = N - 1; i >= 0; i--) {
        if (arr[i] < arr[N]) {
          dp[N] = Math.max(dp[N], LIS(i) + 1);
        }
      }
    }
    return dp[N];
  }
}