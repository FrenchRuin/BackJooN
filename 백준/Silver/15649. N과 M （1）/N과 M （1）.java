import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[M];

        dfs(M, N, 0);
        System.out.println(sb);

    }

    public static void dfs(int M, int N, int dept) {

        if (dept == N) {
            for (int val : arr
            ) {
                sb.append(val).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < M; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[dept] = i + 1;
                dfs(M, N, dept + 1);
                visited[i] = false;
            }
        }
    }
}
