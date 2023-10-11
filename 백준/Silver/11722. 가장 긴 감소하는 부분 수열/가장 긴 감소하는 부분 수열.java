import java.util.*;
import java.io.*;

public class Main {

  /*
   * 
   * 가장 긴 감소하는 부분 수열
   * 
   * A = {10, 30, 10, 20, 20, 10}
   * dp[1] = 10 = 1
   * dp[2] = 30,10 / 30,20 / 30,20,10 = 3
   * dp[3] = 10 = 1
   * dp[4] = 20 / 20,10 = 2
   * dp[5] = 20,10 = 1
   * 
   */
  static int N;
  static int[] dp;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    dp = new int[N + 1];
    arr = new int[N + 1];

    // 1로 초기화 및 arr 배열 입력
    for (int i = 1; i <= N; i++) {
      arr[i] = sc.nextInt();
      dp[i] = 1;
    }

    int maxCnt = 0;

    for (int i = 1; i <= N; i++) {
      dp[i] = 1;
      for (int j = 1; j < i; j++) {
        if (arr[j] > arr[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxCnt = Math.max(maxCnt, dp[i]);
    }

    System.out.println(maxCnt);
  }
}
