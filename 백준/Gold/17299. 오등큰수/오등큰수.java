import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] inputNum = br.readLine().split(" ");

        int[] result = new int[N]; // 결과값

        int[] nums = new int[N]; //입력된 숫자
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(inputNum[i]);
        }

        int[] nums_cnt = new int[1000001];
        for (int i = 0; i < N; i++) {
            nums_cnt[nums[i]] += 1;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            while (!stack.isEmpty() && nums_cnt[nums[stack.peek()]] < nums_cnt[nums[i]]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}