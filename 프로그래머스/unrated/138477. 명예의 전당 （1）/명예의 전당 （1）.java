import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
          if(temp.size() < k){
            temp.add(score[i]);
          }else{
            if(temp.get(0) < score[i]){
              temp.set(0, score[i]);
            }
          }

          Collections.sort(temp);
          answer[i] = temp.get(0);
        }
        return answer;
    }
}