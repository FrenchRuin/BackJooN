import sys

input = sys.stdin.readline

N, K = map(int, input().split())

coins = []
for _ in range(N):
    coins.append(int(input()))

dp = [10001] * (K + 1)
dp[0] = 0

for c in coins:
    for i in range(c, K + 1):
        if dp[i] > 0:
            dp[i] = min(dp[i], dp[i - c] + 1)

print(dp[K] if dp[K] != 10001 else -1)
