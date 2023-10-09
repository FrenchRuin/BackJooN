import java.util.*;
import java.io.*;

public class Main {

  /*
   * 
   * 오르막수
   * 
   * dp[i][j] += dp[i-1][k];
   * dp[i][j] %= 10007;
   * 
   * 0 1 2 3 4 5 6 7 8 9
   * 1 1 1 1 1 1 1 1 1 1 1
   * 2 10 9 8 7 6 5 4 3 2 1
   * 3 55 45 36 28 21 15 10 6 3 1
   * 
   */
  static int N;
  static long[][] dp;

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    N = sc.nextInt(); // 입력
    dp = new long[N + 1][10];

    // 초기화
    for (int i = 0; i < 10; i++) {
      dp[0][i] = 1;
    }

    for (int i = 1; i < N + 1; i++) {
      for (int j = 0; j < 10; j++) {
        for (int k = j; k < 10; k++) {
          dp[i][j] += dp[i - 1][k];
          dp[i][j] %= 10007;
        }
      }
    }
    System.out.println(dp[N][0]);

  }
}
