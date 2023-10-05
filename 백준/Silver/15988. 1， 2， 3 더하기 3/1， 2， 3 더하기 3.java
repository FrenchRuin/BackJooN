import java.util.*;

class Main {
  public static void main(String[] args) {

    /*
     * 1,2,3 더하기
     * 
     * 
     * 점화식에 관한 규칙을 구해야한다.
     * 
     * 1 >> 1
     * 2 >> 1+1 , 2 >> 2
     * 3 >> 1+1+1, 1+2, 2+1 , 3 >> 4
     * 
     * 단순하게 접근하자.
     */

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long dp[] = new long[1000001];

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i = 4; i < dp.length; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      sb.append(dp[sc.nextInt()]);

      if (i != N - 1) {
        sb.append("\n");
      }
    }

    System.out.println(sb);

  }
}