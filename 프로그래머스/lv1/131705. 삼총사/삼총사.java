class Solution {
    public int solution(int[] number) {
        int answer = 0;

        for (int i = 0; i < number.length - 2; i++) {
          for (int j = i+1; j < number.length - 1; j++) {
            for (int j2 = j + 1; j2 < number.length; j2++) {
              if(number[i] + number[j] + number[j2] == 0 ) answer++;
            }
          }
        }


        return answer;
    }
}