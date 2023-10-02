import java.util.*;
import java.io.*;

public class Main {

  /*
   * 
   * 이친수
   * 
   * 1. 이친수는 0으로 시작하지 않는다.
   * 2. 이친수에서는 1이 연속으로 시작되지 않는다.
   * ex ) 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다.
   * 
   * 앞자리가 1이면 0밖에 못오고,
   * 앞자리가 0이면 1,0 둘다 올 수 있다.
   * 
   * 2 >> 1개
   * 10
   * 
   * 
   * 3이 입력되면
   * 101
   * 100 >> 2개의 경우의수가 도출된다.
   * 
   * 4가 입력되면 >> 3개
   * 1010
   * 1001
   * 1000
   * 
   * 5가 입력되면 >> 5개
   * 10101
   * 10100
   * 10010
   * 10001
   * 10000
   * 
   * 6 >> 8개
   * 101010
   * 101001
   * 101000
   * 100101
   * 100100
   * 100010
   * 100001
   * 100000
   * 
   * 2 - 1개
   * 3 - 2개
   * 4 - 3개
   * 5 - 5개
   * 6 - 8개
   * 
   * dp[i] = dp[i-1] + dp[i -2];
   */

  static int N;
  static long dp[];

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    dp = new long[101];

    dp[1] = 1;
    dp[2] = 1;
    for (int i = 3; i <= 100; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    System.out.println(dp[N]);
  }
}