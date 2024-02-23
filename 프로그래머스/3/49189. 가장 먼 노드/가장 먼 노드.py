from collections import deque

def solution(n, edge):
    answer = 0
    
    graph = [[] for i in range(n + 1)] 
    visited = [0] * (n + 1)
    for s,e in edge : 
        graph[s].append(e)
        graph[e].append(s)
    
    queue = deque([1])
    visited[1] = 1
    while queue : 
        t = queue.popleft()
        for i in graph[t] :
            if not visited[i]:
                visited[i] = visited[t] + 1
                queue.append(i)
                
    maxV = max(visited)
    return visited.count(maxV)