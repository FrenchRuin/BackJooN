import sys

T = int(sys.stdin.readline())
# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):  # 방문처리한것은 1에서 0으로 변경한다.
    queue = [(x, y)]
    Maps[x][y] = 0

    while queue:
        x, y = queue.pop(0)
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue

            if Maps[nx][ny] == 1:
                queue.append((nx, ny))
                Maps[nx][ny] = 0


for i in range(T):
    M, N, K = map(int, sys.stdin.readline().split())  # 조건
    answer = 0

    Maps = [[0] * M for _ in range(N)]  # 지도 초기화
    # 지도 생성
    for j in range(K):
        location = list(map(int, sys.stdin.readline().split()))
        Maps[location[1]][location[0]] = 1

    for k in range(N):
        for l in range(M):
            if Maps[k][l] == 1:
                bfs(k, l)
                answer += 1

    print(answer)