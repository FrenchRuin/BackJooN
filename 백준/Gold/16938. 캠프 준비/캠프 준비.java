import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, l, r, x;
    public static int[] arr = new int[15];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i=0; i<n; i++)
            answer += Back(arr[i], i+1, arr[i], arr[i]);
        System.out.println(answer);
    }

    public static int Back(int sum, int index, int min, int max) {
        int ret = 0;
        max = Integer.max(arr[index-1], max);
        min = Integer.min(arr[index-1], min);

        if (l <= sum && max-min >= x)
            ret += 1;

        if (index == n)
            return ret;

        for (int i=index; i<n; i++) {
            if (sum + arr[i] <= r)
                ret += Back(sum+arr[i], i+1, min, max);
        }
        return ret;
    }
}