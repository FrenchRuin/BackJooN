from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    
    
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    visited= [[1] * 102 for _ in range(102)]
    maps = [ [-1] * 102 for _ in range(102) ]
    
    
    for r in rectangle :  # map 생성
        x1,y1,x2,y2 = map(lambda x : x*2 , r)
        for i in range(x1,x2 + 1) :
            for j in range(y1, y2 + 1) :
                if x1 < i < x2 and y1<j < y2 :
                    maps[i][j] = 0
                elif maps[i][j] != 0 :
                    maps[i][j] = 1
                    
    queue =deque()
    queue.append((characterX * 2 , characterY * 2))
    
    answer = 0
    while queue : 
        x,y = queue.popleft()
        
        if itemX*2 == x and itemY * 2 == y :
            answer = visited[x][y] // 2
            break
            
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0<=nx<102 and 0<=ny<102 :
                if visited[nx][ny] == 1 and maps[nx][ny] == 1:
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append((nx,ny))
    
        
    return answer