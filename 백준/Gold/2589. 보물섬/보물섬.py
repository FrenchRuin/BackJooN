from collections import deque

L, W = map(int, input().split())

maps = [list(map(str, input())) for _ in range(L)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
  count = [[0] * (W) for _ in range(L)]
  queue = deque()
  queue.append((x, y))
  count[x][y] = 1
  cnt = 0
  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < L and 0 <= ny < W:
        if count[nx][ny] == 0 and maps[nx][ny] == 'L':
          count[nx][ny] = count[x][y] + 1
          cnt = max(cnt, count[nx][ny])
          queue.append((nx, ny))

  return cnt - 1


answer = 0
for i in range(L):
  for j in range(W):
    if maps[i][j] == 'L':
      answer = max(answer, bfs(i, j))
      if answer == (L + W - 2):
        break

print(answer)
