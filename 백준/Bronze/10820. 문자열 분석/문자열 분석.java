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

        String data = "";
        while ((data = br.readLine()) != null) {
            int[] arr = new int[4];

            for (int i = 0; i < data.length(); i++) {

                // 소문자
                if (data.charAt(i) >= 'a' && data.charAt(i) <= 'z') {
                    arr[0] += 1;
                }
                // 대문자
                if (data.charAt(i) >= 'A' && data.charAt(i) <= 'Z') {
                    arr[1] += 1;
                }
                // 숫자
                if (data.charAt(i) >= '0' && data.charAt(i) <= '9') {
                    arr[2] += 1;
                }
                // 공백
                if (data.charAt(i) == ' ') {
                    arr[3] += 1;
                }
            }

            for (int j : arr) {
                sb.append(j).append(" ");
            }

        }
        sb.append("\n");
        System.out.println(sb);
    }
}