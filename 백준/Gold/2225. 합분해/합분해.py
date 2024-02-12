"""

합분해 >_<

0 ~ N 까지의 정수 K개를 더한다...

dp[n][k]
"""

import sys

input = sys.stdin.readline

N, K = map(int, input().split())

dp = [[0] * N for _ in range(K)]

for i in range(N):
    dp[0][i] = 1

for i in range(K):
    dp[i][0] = i + 1

for i in range(1, K):
    for j in range(1, N):
        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000

print(dp[K - 1][N - 1])
