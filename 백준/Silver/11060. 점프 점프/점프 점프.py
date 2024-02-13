import sys

input = sys.stdin.readline

N = int(input())
dp = [N + 1] * N  # 최솟값을 주기위해 최대 큰 값을 가져간다.
dp[0] = 0

miro = list(map(int, input().split()))

for i in range(N):
    for j in range(1, miro[i] + 1):
        if i + j < N:
            dp[i + j] = min(dp[i] + 1, dp[i + j])

print(dp[N - 1] if dp[N - 1] != N + 1 else -1)
