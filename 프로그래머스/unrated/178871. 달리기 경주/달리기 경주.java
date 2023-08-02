import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        HashMap<String, Integer> playerMap = new HashMap<>();
        HashMap<Integer, String> rankMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
            rankMap.put(i, players[i]);
         }

         for (int i = 0; i < callings.length; i++) {

             int currRank = playerMap.get(callings[i]);
             String player = rankMap.get(currRank);

            String frontPlayer = rankMap.get(currRank - 1);

             playerMap.put(player, currRank - 1);
             playerMap.put(frontPlayer, currRank);
        
             rankMap.put(currRank - 1, player);
             rankMap.put(currRank, frontPlayer);

         }

        for (int i = 0; i < players.length; i++) {
            answer[i] = rankMap.get(i);
         }
        return answer;

    }
}