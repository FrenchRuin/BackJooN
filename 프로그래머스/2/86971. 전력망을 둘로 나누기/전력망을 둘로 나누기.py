from collections import deque

def solution(n, wires):
    answer = 101
    
    graph = [ [] for _ in range(n + 1)]
    
    for a,b in wires :
        graph[a].append(b)
        graph[b].append(a)
        
    for start,end in wires :
        visited = [0] * (n + 1)
        cnt = bfs(start,end,visited,graph)
        left = n - cnt
        answer = min(answer , abs(n - cnt*2))
    
    return answer


def bfs(start,end,visited,graph) : 
    visited[start] = 1
    visited[end] = 1
    queue = deque()
    queue.append(end)
    cnt = 1
    while queue :
        now = queue.popleft()
        for v in graph[now] :
            if not visited[v] :
                visited[v] = 1
                cnt += 1
                queue.append(v)
    
    return cnt