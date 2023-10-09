import java.util.*;
import java.io.*;

public class Main {

  /*
   * 
   * 스티커
   * 
   * 
   * 
   */

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int caseNum = Integer.parseInt(br.readLine());

      int[][] stickers = new int[2][caseNum + 1];
      int[][] dp = new int[2][caseNum + 1];

      for (int j = 0; j < 2; j++) {
        String[] inputs = br.readLine().split(" ");
        for (int k = 1; k <= caseNum; k++) {
          stickers[j][k] = Integer.parseInt(inputs[k - 1]);
        }
      }

      dp[0][1] = stickers[0][1];
      dp[1][1] = stickers[1][1];

      for (int j = 2; j <= caseNum; j++) {
        dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
        dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
      }
      System.out.println(Math.max(dp[1][caseNum], dp[0][caseNum]));
    }
  }
}
