import sys

input = sys.stdin.readline

N = int(input())

dp = [0] * 301
stairs = [0] * 301

for i in range(1, N + 1):
    stairs[i] = int(input())

dp[1] = stairs[1]
dp[2] = stairs[1] + stairs[2]
dp[3] = max(stairs[1] + stairs[3], stairs[2] + stairs[3])

for n in range(4, N + 1):
    dp[n] = max(dp[n - 3] + stairs[n - 1] + stairs[n], dp[n - 2] + stairs[n])

print(dp[N])
