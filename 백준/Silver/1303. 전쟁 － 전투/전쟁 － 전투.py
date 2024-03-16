import sys

input = sys.stdin.readline

N, M = map(int, input().split())
maps = [list(input().strip()) for _ in range(M)]
visited = [[0] * N for _ in range(M)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

answer = [0, 0]


def dfs(x, y, target):
    global cnt
    cnt += 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < M and 0 <= ny < N:
            if not visited[nx][ny] and maps[nx][ny] == target:
                visited[nx][ny] = 1
                dfs(nx, ny, target)


cnt = 0
for i in range(M):
    for j in range(N):
        if not visited[i][j]:
            visited[i][j] = 1
            cnt = 0
            dfs(i, j, maps[i][j])
            if maps[i][j] == 'B':
                answer[1] += cnt * cnt
            else:
                answer[0] += cnt * cnt

print(' '.join(map(str,answer)))
