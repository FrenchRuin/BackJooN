import java.util.*;

public class Main {

    /*
    * 모든 경우의 수는 곱하기로 들어간다?
    *
    * dp[10000001][3];
    *
    * dp[줄][0] = 해당줄에아무것도 두지않음
    * dp[줄][1] = 해당줄에 첫번째에둠
    * dp[줄][2] = 해당줄에 두번째에둠
    *
    * 각각의 경우의수는 1;
    *
    * 그럼 두번째 줄에는?
    * dp[줄][0] = dp[줄-1][0] + dp[줄-1][1] + dp[줄-1][2];
    * dp[줄][1] = dp[줄-1][0] + dp[줄-1][2];
    * dp[줄][2] = dp[줄-1][0] + dp[줄-1][1];
    *
    * */

    static long[][] dp;
    static int N;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dp = new long[100001][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2] ) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901  ;
        }

        System.out.print((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
    }
}
