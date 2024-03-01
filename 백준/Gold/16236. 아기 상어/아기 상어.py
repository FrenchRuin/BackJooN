import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

maps = []
for _ in range(N):
  maps.append(list(map(int, input().split())))

x, y, shark_size = 0, 0, 2
# 9 찾기
for i in range(N):
  for j in range(N):
    if maps[i][j] == 9:
      x = i
      y = j

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y, shark_size):
  dist = [[0] * N for _ in range(N)]
  visited = [[0] * N for _ in range(N)]
  queue = deque()
  queue.append((x, y))
  visited[x][y] = 1
  tempList = []

  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
        if maps[nx][ny] <= shark_size:
          queue.append((nx, ny))
          visited[nx][ny] = 1
          dist[nx][ny] = dist[x][y] + 1
          if maps[nx][ny] < shark_size and maps[nx][ny] != 0:
            tempList.append((nx, ny, dist[nx][ny]))

  return sorted(tempList, key=lambda x: (-x[2], -x[0], -x[1]))


cnt = 0
result = 0
while True:
  sharks = bfs(x, y, shark_size)

  if len(sharks) == 0:
    break

  nx, ny, dist = sharks.pop()

  result += dist
  maps[x][y], maps[nx][ny] = 0, 0

  x, y = nx, ny
  cnt += 1
  if cnt == shark_size:
    shark_size += 1
    cnt = 0

print(result)
