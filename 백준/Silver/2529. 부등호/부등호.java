import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  /*
   * 
   * 조건에 만족하는 모든 수열을 list에 모두 저장한 후, 정렬한 다음 처음과 마지막 값을 출력한다.
   * 이것이 관건...
   * 
   */

  static int K; // 입력정수
  static char[] icon = new char[10]; // 부등호 최대 10개
  static boolean[] visited = new boolean[10]; // 0 ~9 까지 방문여부;
  static List<String> answer = new ArrayList<>(); // 모든 답을 담을 리스트

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    K = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      icon[i] = st.nextToken().charAt(0);
    }

    dfs("", 0);
    System.out.println(answer.get(answer.size() - 1));
    System.out.println(answer.get(0));

  }

  static void dfs(String num, int depth) {
    // 돌면 리스트에 추가
    if (depth == K + 1) {
      answer.add(num);
      return;
    }

    for (int i = 0; i <= 9; i++) {

      if (visited[i]) // 방문했으면 continue
        continue;

      // 첫방문이거나, 두수를 비교했을때 통과하면
      if (depth == 0 || checkNumSize(Character.getNumericValue(num.charAt(depth - 1)), i, icon[depth - 1])) {
        visited[i] = true;
        dfs(num + i, depth + 1);
        visited[i] = false;
      }
    }

  }

  static boolean checkNumSize(int target, int now, int ic) {
    if (ic == '<') {
      if (target > now)
        return false;
    } else if (ic == '>') {
      if (target < now)
        return false;
    }

    return true;
  }
}
