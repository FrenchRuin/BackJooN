import java.util.*;
import java.io.*;

public class Main {

  /*
   * 제곱수의 합
   * 
   * 이해해보자 이해해보자...
   * 
   * dp[1] = 1^2; >> 1
   * dp[2] = 1^2 + 1^2; >> 2
   * dp[3] = 1^2 + 1^2 + 1^2; >> 3
   * dp[4] = 2^2 >> 1
   * dp[5] = 2^2 + 1^2 >> 1 + 1 = 2;
   * 
   * 
   */

  static int N;
  static int dp[];

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    dp = new int[100001];

    dp[1] = 1;

    for (int i = 2; i <= N; i++) {
      dp[i] = i;
      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i - (j * j)] + 1, dp[i]);
      }
    }

    System.out.println(dp[N]);
  }
}
