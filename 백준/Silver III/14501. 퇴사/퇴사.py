import sys
from collections import deque

input = sys.stdin.readline
N = int(input())

plans = [[0, 0]] + [list(map(int, input().split())) for _ in range(N)]

queue = deque()
queue.append((1, 0))

answer = 0

while queue:
    T, P = queue.popleft()
    answer = max(answer, P)

    if T + 1 <= N:
        queue.append((T + 1, P))

    if T <= N and T + plans[T][0] <= N + 1:
        queue.append((T + plans[T][0], P + plans[T][1]))

print(answer)
