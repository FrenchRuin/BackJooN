
import java.util.*;

/*
 * 
 * >문제 풀이
1. 인접 행렬 또는 인접리스트를 이용해서 그래프를 표현해줍니다.

2. for(반복문) : 선을 하나씩 끊어보며, 나눠진 두 전력망의 송전탑 개수의 차이를 구할 것입니다.

2-1) 선 하나를 끊습니다.

2-2) bfs 를 이용하여 끊어진 선의 두 노드 중 하나를 선택하여 연결된 송전탑의 개수를 구해줍니다.(=cnt)

- 두 전력망은 각각 (cnt) 와 ( n-cnt )개의 송전탑을 가질 것입니다.

- Math.abs(n-2*cnt) : 두 전력망이 가지고 있는 송전탑의 개수의 차

- 최솟값을 answer에 갱신해줍니다.

2-3) 선을 다시 복구시켜줍니다.
 */
class Solution {

  static int[][] arr;

  public int solution(int n, int[][] wires) {
    int answer = 99999;

    arr = new int[n + 1][n + 1];

    for (int i = 0; i < wires.length; i++) {
      arr[wires[i][0]][wires[i][1]] = 1;
      arr[wires[i][1]][wires[i][0]] = 1;
    }

    int a, b;
    for (int i = 0; i < wires.length; i++) {
      a = wires[i][0];
      b = wires[i][1];

      arr[a][b] = 0;
      arr[b][a] = 0;

      answer = Math.min(answer, bfs(n, a));

      arr[a][b] = 1;
      arr[b][a] = 1;
    }

    return answer;
  }

  static int bfs(int n, int start) {
    boolean visited[] = new boolean[n + 1];
    int cnt = 1;
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);

    while (!queue.isEmpty()) {
      int point = queue.poll();
      visited[point] = true;

      for (int i = 1; i <= n; i++) {
        if (visited[i]) {
          continue;
        }

        if (arr[point][i] == 1) {
          queue.offer(i);
          cnt++;
        }
      }
    }

    return Math.abs(n - 2 * cnt);
  }
}