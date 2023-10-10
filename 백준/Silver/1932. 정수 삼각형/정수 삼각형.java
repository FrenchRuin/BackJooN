import java.util.*;
import java.io.*;

public class Main {

  /*
   * 
   * 포도주 시식
   * 
   * 3번째 잔이면 continue 하여 sum??
   * 
   */

  static int N;
  static int[][] triangle;
  static Integer[][] dp;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    triangle = new int[N][N];
    dp = new Integer[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i + 1; j++) {
        triangle[i][j] = sc.nextInt();
      }
    }

    // 마지막행은 입력해준다.
    for (int i = 0; i < N; i++) {
      dp[N - 1][i] = triangle[N - 1][i];
    }

    System.out.println(findMaxValue(0, 0));

  }

  static int findMaxValue(int depth, int idx) {
    if (depth == N - 1)
      return dp[depth][idx];

    if (dp[depth][idx] == null) {
      dp[depth][idx] = Math.max(findMaxValue(depth + 1, idx), findMaxValue(depth + 1, idx + 1)) + triangle[depth][idx];
    }

    return dp[depth][idx];
  }
}
