import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int CP = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        StringTokenizer num = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Math.abs(CP - Integer.parseInt(num.nextToken()));
        }
        int GCD= arr[0];
        for (int i = 0; i < N; i++) {
            GCD = gcd(GCD, arr[i]);
        }
        System.out.println(GCD);


    }

    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a % b);
    }
}
