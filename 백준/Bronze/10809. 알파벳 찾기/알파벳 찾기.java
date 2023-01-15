import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String data = br.readLine();

        int[] cnt = new int[26];
        Arrays.fill(cnt, -1);

        for (int i = 0; i < data.length(); i++) {

            if (!(cnt[data.charAt(i) - 'a'] >-1))
                cnt[data.charAt(i) - 'a'] = i;
        }

        for (int j : cnt) {
            sb.append(j).append(" ");
        }

        System.out.println(sb);
    }
}