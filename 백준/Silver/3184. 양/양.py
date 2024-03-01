import sys
from collections import deque

input = sys.stdin.readline

R, C = map(int, input().split())

maps = [list(map(str, input().strip())) for _ in range(R)]
visited = [[0] * C for _ in range(R)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

answer = [0,0]


def bfs(x, y):
  wolf = 0
  sheep = 0
  queue = deque()
  queue.append((x, y))

  while queue:
    x, y = queue.popleft()

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < R and 0 <= ny < C:
        if not visited[nx][ny] and maps[nx][ny] != '#':
          visited[nx][ny] = 1
          if maps[nx][ny] == 'v':
            wolf += 1
          elif maps[nx][ny] == 'o':
            sheep += 1
          queue.append((nx, ny))
  if sheep > wolf :
    answer[0] += sheep
  else :
    answer[1] += wolf
  
for i in range(R) :
  for j in range(C) :
    bfs(i,j)
    
for a in answer :
  print(a,end=' ')