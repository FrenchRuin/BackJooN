import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // 진수 변환
        String str = Integer.toString(n, k);

        // str에서 0을 모두 제거
        String[] strArr = str.split("0");

        // 00 일시, 공백이 생겨서 공백 배열칸 제거
        strArr = Arrays.stream(strArr).filter(s -> (s != null && s.length() > 0)).toArray(String[]::new);

        for (String string : strArr) {
            if (isPrime(Long.parseLong(string)))
                answer++;
        }

        return answer;
    }

    static Boolean isPrime(Long num) {
        if (num == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
