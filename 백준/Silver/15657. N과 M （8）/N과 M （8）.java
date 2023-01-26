import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    public static int[] arr;
    public static int[] result;
    public static boolean[] visited;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new int[N];
        result = new int[M];
        visited = new boolean[N + 1];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb);

    }

    public static void dfs(int at, int depth) {
        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(' ');
            }
            sb.append('\n');

        }else{
            for (int i = at; i < N; i++) {
            result[depth] = arr[i];
            dfs(i, depth + 1);
           }
        }
    }
}