from collections import deque



def solution(maps):
    answer = 0
    answer = bfs(maps)
    
    if answer == 0 :
        return -1
    
    return answer

def bfs(maps) :
    
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    
    n = len(maps[0])
    m = len(maps)
    visited = [[1] * (n + 1) for _ in range(m + 1)]
    queue = deque()
    queue.append((0,0))
    cnt = 0
    while queue : 
        x,y = queue.popleft()
        if x == m - 1 and y == n - 1 :
            cnt = visited[x][y]
            break
            
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0<=nx<m and 0<=ny<n :
                if visited[nx][ny] == 1 and maps[nx][ny] == 1 :
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append((nx,ny))
    return cnt