import java.util.*;
import java.io.*;

public class Main {

  static int N;
  static int P[] = new int[1001];
  static int D[] = new int[10001];

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      P[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N; i++) {
      D[i] = P[i];
      for (int j = 1; j <= i; j++) {
        D[i] = Math.min(D[i], D[i - j] + P[j]);
      }
    }

    System.out.println(D[N]);
  }
}