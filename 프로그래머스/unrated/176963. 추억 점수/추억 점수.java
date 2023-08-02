class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
         int[] answer = new int[photo.length];

    for (int i = 0; i < photo.length; i++) {
      for (int j = 0; j < photo[i].length; j++) {
        for (int j2 = 0; j2 < name.length; j2++) {
          if(photo[i][j].equals(name[j2])){
            answer[i] += yearning[j2];
          }
        }              
      }

    }
    return answer;
    }
}