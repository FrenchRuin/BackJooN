import java.util.*;
import java.io.*;

public class Main {

  /*
   * 
   * 가장 큰 증가하는 부분 수열
   * 
   * A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8}
   * 가장 큰 증가하는 부분 수열
   * dp값에 A값을 복사.
   * 
   * for int= 1 ; i<= N ; i++ {
   * for int j=1 ; j < i ; j++ {
   * if(A[])
   * }
   * }
   * 
   * 
   * 
   */

  static int N;
  static int[] dp;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    dp = new int[N + 1];
    arr = new int[N + 1];

    // 입력받기 및 dp와 arr 통일
    for (int i = 1; i <= N; i++) {
      arr[i] = sc.nextInt();
      dp[i] = arr[i];
    }

    int result = dp[1]; // 값이 하나 떨어지면 return

    for (int i = 2; i <= N; i++) {
      for (int j = 1; j < i; j++) {
        if (arr[j] < arr[i]) {
          dp[i] = Math.max(dp[j] + arr[i], dp[i]);
          result = Math.max(result, dp[i]);
        }
      }
    }
    System.out.println(result);
  }
}
