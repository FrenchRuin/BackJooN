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

        String[] data = br.readLine().split(" ");
        long num1 = Long.parseLong(data[0] + data[1]);
        long num2 = Long.parseLong(data[2] + data[3]);

        sb.append(num1 + num2);
        System.out.println(sb);
    }
}