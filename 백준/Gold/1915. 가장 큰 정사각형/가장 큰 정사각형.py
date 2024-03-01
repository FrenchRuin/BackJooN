import sys

input = sys.stdin.readline

N, M = map(int, input().split())

maps = []
for _ in range(N):
    maps.append(list(map(int, input().strip())))

dp = [[0] * M for _ in range(N)]

answer = 0
for i in range(N):
    for j in range(M):
        if i == 0 or j == 0:
            dp[i][j] = maps[i][j]
        elif maps[i][j] == 0:
            dp[i][j] = 0
        else:
            dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1
        answer = max(dp[i][j], answer)

print(answer * answer)
