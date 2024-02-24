from collections import deque

def solution(maps):
    answer = 0
    w = len(maps[0])
    h = len(maps)
    visited = [[0] * (w + 1) for _ in range(h + 1)]
    
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    queue = deque()
    queue.append((0,0))
    visited[0][0] = 1
    while queue :
        x,y = queue.popleft()
        
        if x == h - 1 and y == w - 1 :
            answer = visited[x][y]
            break
        
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0<=nx<h and 0<=ny<w :
                if not visited[nx][ny] and maps[nx][ny] == 1 :
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append((nx,ny))
                    
    return answer if answer >0 else -1