import java.util.*;

class Solution {

    private static boolean[] visited;
    private static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        return explore(dungeons, k, visited, 0);
    }

    private static int explore(int[][] dungeons, int k, boolean[] visited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                explore(dungeons, k - dungeons[i][1], visited, count + 1);
                visited[i] = false;
            }
        }

        answer = Math.max(count, answer);

        return answer;
    }
}