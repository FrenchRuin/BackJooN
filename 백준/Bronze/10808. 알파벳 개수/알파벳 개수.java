import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String data = br.readLine();

        int[] cnt = new int[26];

        for (int i = 0; i < data.length(); i++) {
            cnt[data.charAt(i) - 'a'] += 1;
        }

        for (int j : cnt) {
            sb.append(j).append(" ");
        }

        System.out.println(sb);
    }
}