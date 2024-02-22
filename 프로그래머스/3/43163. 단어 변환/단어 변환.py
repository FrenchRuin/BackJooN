from collections import deque

def solution(begin, target, words):
    answer = 0
    
    if target not in words :
        return 0
    
    return bfs(begin, target, words)

def bfs(begin, target, words) :
    queue = deque()
    queue.append((begin,0))
    
    while queue :
        begin, cnt = queue.popleft()
        
        if begin == target :
            return cnt
        
        for w in words :
            diff = 0
            for i in range(len(w)) :
                if begin[i] != w[i] :
                    diff += 1
            
            if diff == 1 :
                queue.append((w,cnt + 1))


