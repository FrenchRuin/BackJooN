import java.util.*;

class Main {

  static int R = 0;
  static int G = 1;
  static int B = 2;

  static int[][] pay;
  static int[][] dp;

  public static void main(String[] args) {
    /*
     * 누적합을 사용하자.
     * 1 100 103 >> dp[1][0] , dp[1][1], dp[1][2]
     * 1 103 200 >> dp[2][0] += Math.min(dp[1][1], dp[1][2]), dp[2][1] +=
     * Math.min(dp[1][0], dp[1][2]),
     * 100 1 103
     * 
     */

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    pay = new int[N][3];
    dp = new int[N][3];

    for (int i = 0; i < N; i++) {
      pay[i][R] = sc.nextInt();
      pay[i][G] = sc.nextInt();
      pay[i][B] = sc.nextInt();
    }

    // 첫번째 집의 경우는 각자의 비용으로 초기화 시켜준다.
    dp[0][R] = pay[0][R];
    dp[0][G] = pay[0][G];
    dp[0][B] = pay[0][B];

    System.out.println(Math.min(work(N - 1, R), Math.min(work(N - 1, G), work(N - 1, B))));
  }

  static int work(int N, int color) {
    // 탐색 안했으면
    if (dp[N][color] == 0) {
      if (color == R) { // red
        dp[N][color] = Math.min(work(N - 1, G), work(N - 1, B)) + pay[N][R];
      } else if (color == G) {
        dp[N][color] = Math.min(work(N - 1, R), work(N - 1, B)) + pay[N][G];
      } else {
        dp[N][color] = Math.min(work(N - 1, R), work(N - 1, G)) + pay[N][B];
      }
    }
    return dp[N][color];
  }
}