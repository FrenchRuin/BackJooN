import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int L,C;
    public static char[] list;
    public static char[] code;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         L = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());

        code = new char[L];
        list = new char[C];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < C; i++) {
            list[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(list);
        makeCode(0, 0);
    }

    public static void makeCode(int x, int idx) {
        if (idx == L) {
            if (isValid()) {
                System.out.println(code);
            }
            return;
        }
        for (int i = x; i < C; i++) {
            code[idx] = list[i];
            makeCode(i + 1, idx + 1);
        }

    }

    public static boolean isValid() {
        int mo = 0;
        int ja = 0;
        for (char x : code) {
            if (x == 'a' || x == 'i' || x == 'e' || x == 'o' || x == 'u') {
                mo++;
            }else {
                ja++;
            }
        }
        return mo >= 1 && ja >= 2;
    }
}