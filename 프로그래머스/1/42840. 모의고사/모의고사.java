import java.util.*;

/*
 * 모의고사
 * 
 * 1번 수포자 = {1,2,3,4,5} // 5
 * 2번 수포자 = {2,1,2,3,2,4,2,5} // 8
 * 3번 수포자 = {3,3,1,1,2,2,4,4,5,5} // 10
 * 
 * 
 */
class Solution {

  public int[] solution(int[] answers) {

    int[] first = new int[] { 1, 2, 3, 4, 5 };
    int[] second = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
    int[] third = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

    int[] score = new int[] { 0, 0, 0 };

    for (int i = 0; i < answers.length; i++) {
      if (first[i % 5] == answers[i]) {
        score[0]++;
      }

      if (second[i % 8] == answers[i]) {
        score[1]++;
      }

      if (third[i % 10] == answers[i]) {
        score[2]++;
      }
    }

    int max = Math.max(score[0], Math.max(score[1], score[2]));

    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < score.length; i++) {
      if (max == score[i]) {
        list.add(i + 1);
      }
    }

    int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

    return answer;
  }
}