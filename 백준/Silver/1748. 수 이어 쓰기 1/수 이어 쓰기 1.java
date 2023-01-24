import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = 10;
        int plus = 1;
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (i%num == 0) {
                plus++;
                num *= 10;
            }

            cnt += plus;

        }

        System.out.println(cnt);

    }


}
