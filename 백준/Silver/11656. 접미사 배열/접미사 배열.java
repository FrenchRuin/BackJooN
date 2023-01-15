import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String data = br.readLine();

        String[] str = new String[data.length()];

        for (int i = 0; i < data.length(); i++) {
            str[i] = data.substring(i, data.length());
        }

        Arrays.sort(str);
        for (String string : str) {
            sb.append(string).append("\n");
        }

        System.out.println(sb);
    }
}