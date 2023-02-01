import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int[] day;
    public static int[] pay;
    public static int sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        day = new int[N];
        pay = new int[N];

        sum = 0;

        //데이터 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            day[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            if (i + day[i] <= N) {
                dp[i + day[i]] = Math.max(dp[i + day[i]], dp[i] + pay[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[N]);
    }


}