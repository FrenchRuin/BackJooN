import java.util.*;

/*
 * QUEUE를 다리라고 치자.
 * bridge_length 로 사이즈를 측정한다.
 * 
 * 다리에 올라가있는 무게를 가져가야하고,
 * 시간또한 가져가야한다.
 * 
 * 올리는 시간 건너는시간 내리는 시간 까지 해서 모두 3초가 소요된다.
 */
class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;

    int sum = 0; // 다리에 올라가있는 무게
    int time = 0; // 모든 트럭이 건너는데 필요한 시간

    Queue<Integer> bridge = new LinkedList<>(); // 다리를 Queue로 구현

    // 트럭들을 대상으로 반복문
    for (int i = 0; i < truck_weights.length; i++) {
      int truck = truck_weights[i]; // 현재 건너려는 트럭

      while (true) {
        if (bridge.isEmpty()) { // 건너려는 트럭이 없다면
          bridge.add(truck);
          sum += truck; // 트럭의 무게를 ++;
          time++; // 다리에 올라가는 시간 ++;
          break;
        } else if (bridge.size() == bridge_length) { // 현재 다리에 건너려는 트럭이 꽉차있다면
          sum -= bridge.poll(); // 내려보낸다.
        } else { // 건너고 있는데, 다리에 자리가 남는다면

          if (sum + truck <= weight) { // 건너려는 트럭이 무게를 안넘겨서 건널수있다면
            bridge.add(truck);
            sum += truck;
            time++;
            break;

          } else { // 건널 수 없으면 밀어 내버린다.
            bridge.add(0);
            time++;
          }
        }
      }
    }
    // 마지막에 건너려는 트럭만 남게 되는데, bridge_length에 맞게 더해서 return 해준다.
    answer = time + bridge_length;
    return answer;
  }
}