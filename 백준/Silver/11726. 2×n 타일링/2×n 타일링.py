N = int(input())

dp = [0] * 10001

dp[0] = 1
dp[1] = 2
dp[2] = 3

for i in range(3, N) :
    dp[i] = (dp[i-1] + dp[i-2]) % 10007
   
print(dp[N - 1])