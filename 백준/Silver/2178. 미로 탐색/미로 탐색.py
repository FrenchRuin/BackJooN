import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

maps = [list(map(int, input().strip())) for _ in range(N)]
visited = [[0] * M for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

q = deque()
q.append((0, 0))
visited[0][0] = 1
while q:
    x, y = q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M:
            if not visited[nx][ny] and maps[nx][ny]:
                visited[nx][ny] = visited[x][y] + 1
                q.append((nx, ny))

print(visited[N - 1][M - 1])
