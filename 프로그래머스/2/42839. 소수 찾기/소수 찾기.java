import java.util.*;

/*
 * 소수 찾기 완전탐색이다.
 * 
 * 17 일 경우,
 * 1, 7, 17 , 71 이렇게 모두 비교하면서 들어가자.
 * 
 * 필요한것 >> 소수 체크 함수,
 * 모든 경우의수를 가져갈 DFS
 * 그리고 겹치는 값을 가져가지 않을 HashSet  >> 11 == 011
 * 방문여부를 가져갈 boolean 배열
 */

class Solution {

  static boolean[] visited;
  static Set<Integer> set = new HashSet<>();

  public int solution(String numbers) {
    int answer = 0;

    visited = new boolean[numbers.length()];

    dfs(0, numbers, "");

    answer = set.size();
    return answer;
  }

  static void dfs(int depth, String numbers, String target) {
    if (depth == numbers.length()) {
      return;
    }

    for (int i = 0; i < numbers.length(); i++) {
      if (!visited[i]) {
        visited[i] = true;
        String number = target + numbers.charAt(i);

        // 소수 체크
        if (isPrime(Integer.parseInt(number))) {
          set.add(Integer.parseInt(number));
        }

        dfs(depth + 1, numbers, number);
        visited[i] = false;
      }
    }
  }

  static boolean isPrime(int n) {

    if (n == 0 || n == 1) {
      return false;
    }

    for (int i = 2; i <= (int) Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }
}