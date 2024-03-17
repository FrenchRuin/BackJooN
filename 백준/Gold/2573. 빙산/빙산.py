import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

maps = [list(map(int, input().split())) for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
year = 0


def count_ice(check_ice):
    cnt = 0
    visited = [[0] * M for _ in range(N)]
    q = deque()
    for x, y in check_ice:
        if not visited[x][y]:
            q.append((x, y))
            while q:
                x, y = q.popleft()
                visited[x][y] = 1
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0 <= nx < N and 0 <= ny < M:
                        if maps[nx][ny] > 0 and not visited[nx][ny]:
                            visited[nx][ny] = 1
                            q.append((nx, ny))
            cnt += 1

    if cnt >= 2:
        return True
    else:
        return False


while True:
    maps_ice = [[0] * M for _ in range(N)]
    check_ice = []
    for i in range(N):
        for j in range(M):
            if maps[i][j] > 0:
                check_ice.append((i, j))  # 체크해야할 ice

    if len(check_ice) == 0:
        year = 0
        break
    if count_ice(check_ice):
        break

    for x, y in check_ice:
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if maps[nx][ny] <= 0:
                    maps_ice[x][y] += 1  # 주변의 0의 개수 카운트

    for x, y in check_ice:  # 0의 갯수만큼 감소
        maps[x][y] -= maps_ice[x][y]
    year += 1

print(year if year > 0 else 0)
