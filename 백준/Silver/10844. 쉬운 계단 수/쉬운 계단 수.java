import java.util.*;
import java.io.*;

public class Main {

  /*
   * 2차원 배열로 가져간다.
   * ex ) Dp[자릿수][value] 경우의 수를 가져간다.
   * 여기서 앞자리가 0일경우 1밖에 못오고
   * 앞자리가 9일경우 8밖에 오지못한다.
   * 
   * 그것을 감안해서 코딩하자.
   */

  static int N;
  static int MOD = 1000000000;

  public static void main(String[] args) throws IOException {
    // 나누기를 들어가야 하기때문에 long타입으로 2차원배열을 선언한다.
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    long dp[][] = new long[N + 1][10];

    // 첫번째자리의 수는 경우의 수가 모두 1이다.
    for (int i = 1; i < 10; i++) {
      dp[1][i] = 1;
    }

    // 두번째 자릿수부터 N번째 자릿수까지 탐색한다.
    for (int i = 2; i <= N; i++) {
      for (int j = 0; j < 10; j++) {
        if (j == 9) { // 자리값이 9라면 8밖에 못옴
          dp[i][9] = dp[i - 1][8] % MOD;
        } else if (j == 0) { // 자리값이 0이면 1밖에 못옴
          dp[i][0] = dp[i - 1][1] % MOD;
        } else {
          dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
        }
      }
    }
    long answer = 0;
    for (int i = 0; i < 10; i++) {
      answer += dp[N][i];
    }
    System.out.println(answer % MOD);
  }
}