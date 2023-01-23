import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            if ('A' <= c && c <= 'Z') {
                ans = ans * B + ((c - 'A') + 10);
            }else{
                ans = ans * B + (c - '0');
            }
        }

        System.out.println(ans);
        
    }
}
