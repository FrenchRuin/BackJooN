import sys

input = sys.stdin.readline

N = int(input())

homes = [[0] * 3 for _ in range(N)]
dp = [[0] * 3 for _ in range(1001)]
for i in range(N):
  homes[i] = list(map(int, input().split()))

R, G, B = 0, 1, 2

dp[0][R] = homes[0][R]
dp[0][G] = homes[0][G]
dp[0][B] = homes[0][B]

for i in range(1, N):
  dp[i][R] = min(dp[i - 1][G], dp[i - 1][B]) + homes[i][R]
  dp[i][G] = min(dp[i - 1][R], dp[i - 1][B]) + homes[i][G]
  dp[i][B] = min(dp[i - 1][R],  dp[i - 1][G]) + homes[i][B]

print(min(dp[N - 1]))
