import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int P[] = new int[1001];
  static int D[] = new int[1001];

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 사야하는 카드 갯수
    N = Integer.parseInt(br.readLine());

    String cardPrice = br.readLine();
    StringTokenizer st = new StringTokenizer(cardPrice);

    // 카드값 Insert
    for (int i = 1; i <= N; i++) {
      P[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        D[i] = Math.max(D[i], D[i - j] + P[j]);
      }
    }
    System.out.println(D[N]);
  }
}