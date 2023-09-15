import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        // 캐시사이즈가 0일때의 처리
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String s = cities[i].toUpperCase();
            if (linkedList.remove(s)) {
                answer += 1;
                linkedList.add(s);
            } else {
                answer += 5;
                if (linkedList.size() >= cacheSize) {
                    linkedList.remove(0);
                }

                linkedList.add(s);
            }
        }

        return answer;
    }
}