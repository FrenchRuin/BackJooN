import sys

N = int(sys.stdin.readline())

dp = [[0] * 10 for _ in range(N)]
MOD = 1000000000

dp[0] = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]

for i in range(1, N):
    dp[i][0] = dp[i - 1][1]
    dp[i][9] = dp[i - 1][8]
    for k in range(1, 9):
        dp[i][k] = dp[i - 1][k + 1] + dp[i - 1][k - 1]

print(sum(dp[N - 1]) % MOD)