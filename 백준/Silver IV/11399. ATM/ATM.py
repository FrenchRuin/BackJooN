import sys

input = sys.stdin.readline

N = int(input())
time = list(map(int, input().split()))
time.sort()
answer = [0] * N
answer[0] = time[0]
for i in range(1,N):
    answer[i] = answer[i-1] + time[i]

print(sum(answer))