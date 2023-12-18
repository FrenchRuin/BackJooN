from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    cur_w = 0 # 현재 무게 
    bridge = deque([0] * bridge_length)
    
    while bridge : 
        cur_w -= bridge.popleft()
        answer += 1
        
        if truck_weights : 
            if cur_w + truck_weights[0] <= weight : 
                truck = truck_weights.pop(0)
                bridge.append(truck)
                cur_w += truck
            else :
                bridge.append(0)
    return answer