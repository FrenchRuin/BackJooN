import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (scan.hasNextInt()) {
            int N = scan.nextInt();
            int num = 0;
            for (int i = 1; ; i++) {
                num = (num * 10 + 1) % N;
                if (num == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }

    }
}
