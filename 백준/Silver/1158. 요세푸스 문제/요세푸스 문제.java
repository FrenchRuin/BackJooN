import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    Queue<Integer> que = new LinkedList<Integer>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= N; i++) {
      que.offer(i);
    }
    sb.append("<");
    while (que.size() != 1) {
      for (int i = 0; i < K - 1; i++) {
        que.offer(que.poll());
      }
      sb.append(que.poll() + ", ");
    }
    sb.append(que.poll() + ">");

    System.out.println(sb);
  }

}