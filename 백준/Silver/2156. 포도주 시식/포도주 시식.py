import sys

input = sys.stdin.readline

N = int(input())
dp = [0] * (N + 1)

podo = [0]
for _ in range(N):
    podo.append(int(input()))

dp[1] = podo[1]

if N > 1:
    dp[2] = podo[1] + podo[2]

for i in range(3, N + 1):
    dp[i] = max(dp[i - 3] + podo[i - 1] + podo[i], dp[i - 1], dp[i - 2] + podo[i])

print(dp[N])
