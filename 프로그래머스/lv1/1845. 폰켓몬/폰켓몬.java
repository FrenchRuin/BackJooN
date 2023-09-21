import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        // 중복을 제거하기 위해서 HashSet 생성
        HashSet<Integer> numHashSet = new HashSet<>();

        for (int num : nums) {
            numHashSet.add(num);
        }

        // 총 고를수있는 폰켓몬 갯수
        int div = nums.length / 2;

        // 중복을 제거한 셋의 크기가 div 보다 크면 div를, 그게 아니면 numHashSet의 크기를 return 한다.
        answer = numHashSet.size() > div ? div : numHashSet.size();

        return answer;
    }
}