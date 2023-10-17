import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

  /*
   * 
   */

  static int N;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    // StringTokenizer st = new StringTokenizer(br.readLine());
    N = sc.nextInt();

    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    if (!perm(arr)) {
      sb.append("-1");
    }

    System.out.println(sb);

  }

  static boolean perm(int[] param) {
    int i = param.length - 1;

    while (i > 0 && param[i - 1] >= param[i]) {
      i--;
    }

    if (i <= 0)
      return false;

    int j = param.length - 1;

    while (param[i - 1] >= param[j]) {
      j--;
    }

    // swap
    int temp = param[i - 1];
    param[i - 1] = param[j];
    param[j] = temp;

    j = param.length - 1;

    while (i < j) {
      int tmp = param[i];
      param[i] = param[j];
      param[j] = tmp;
      i++;
      j--;
    }

    for (int k : param) {
      sb.append(k).append(" ");
    }

    return true;
  }

}
