import sys
from collections import deque

N, M = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(N)]

dx = [-1, 1, 0, 0, 1, 1, -1, -1]
dy = [0, 0, -1, 1, 1, -1, 1, -1]

q = deque()

for i in range(N):
    for j in range(M):
        if maps[i][j]:
            q.append((i, j))

while q:
    x, y = q.popleft()
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M:
            if not maps[nx][ny]:
                maps[nx][ny] = maps[x][y] + 1
                q.append((nx, ny))

print(max(map(max, maps)) - 1)
