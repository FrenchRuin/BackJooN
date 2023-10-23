import java.util.LinkedList;
import java.util.Queue;

class Solution {

  static int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public int solution(int[][] maps) {

    int N = maps.length;
    int M = maps[0].length;

    int[][] visited = new int[N][M];

    bfs(maps, visited, N, M);

    int answer = visited[N - 1][M - 1];

    return (answer > 0) ? answer : -1;
  }

  static void bfs(int[][] maps, int[][] visited, int N, int M) {
    int X = 0;
    int Y = 0;
    visited[Y][X] = 1;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { Y, X });

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int R = now[0];
      int C = now[1];

      for (int i = 0; i < 4; i++) {
        int DR = R + direction[i][0];
        int DC = C + direction[i][1];

        if (DR < 0 || DR >= N || DC < 0 || DC >= M)
          continue;

        if (visited[DR][DC] == 0 && maps[DR][DC] == 1) {
          queue.add(new int[] { DR, DC });
          visited[DR][DC] = visited[R][C] + 1;
        }
      }
    }
  }
}
