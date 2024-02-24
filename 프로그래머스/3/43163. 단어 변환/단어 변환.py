from collections import deque

def solution(begin, target, words):
    answer = 0
    queue = deque()
    queue.append((begin, 0))
    
    if target not in words :
        return 0
    
    while queue :
        begin, cnt = queue.popleft()
        
        if begin == target :
            answer = cnt
            break
        
        for w in words :
            dif = 0
            for i in range(len(w)) :
                if begin[i] != w[i] :
                    dif += 1
            
            if dif == 1 :
                queue.append((w, cnt + 1))
    
    return answer