import sys

T = int(sys.stdin.readline())

for i in range(T):
    N = int(sys.stdin.readline())
    dp = [0] * 101
    dp[0] = 1
    dp[1] = 1
    dp[2] = 1

    for k in range(3, N):
        dp[k] = dp[k - 2] + dp[k - 3]

    print(dp[N - 1])