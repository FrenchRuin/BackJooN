import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    public static int[][] arr;
    public static boolean[][] visited;
    public static int N, M, K, answer;
    public static StringBuilder sb = new StringBuilder();
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N + 1][M + 1];
        answer = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0, 0, 0);
        System.out.println(answer);
    }

    public static void solve(int x, int y, int idx, int sum) {
        if (idx == K) {
            answer = Math.max(answer, sum);
            return;
        }else{
            for (int i = x; i < N; i++) {
                for (int j = y; j < M; j++) {
                    if (!visited[i][j]) {
                        if (check(i, j)) {
                            visited[i][j] = true;
                            solve(x, y, idx + 1, sum + arr[i][j]);
                            visited[i][j] = false;
                        }
                    }
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (visited[nx][ny]) {
                    flag = false;
                }
            }
        }
        return flag;
    }

}