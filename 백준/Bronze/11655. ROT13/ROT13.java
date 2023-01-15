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

        char[] rot = br.readLine().toCharArray();

        for (int i = 0; i < rot.length; i++) {
            if (rot[i] >= 'A' && rot[i] <= 'Z') {
                if (rot[i] >= 'N') {
                    rot[i] -= 13;
                } else {
                    rot[i] += 13;

                }
            } else if (rot[i] >= 'a' && rot[i] <= 'z') {
                if (rot[i] >= 'n') {
                    rot[i] -= 13;
                } else {
                    rot[i] += 13;
                }
            }
        }

        for (char j : rot) {
            sb.append(j);
        }

        System.out.println(sb);
    }
}