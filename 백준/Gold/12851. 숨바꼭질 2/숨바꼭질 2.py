import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

answer = []
visited = [0] * 100001

q = deque()
q.append(N)

while q:
    x = q.popleft()
    if x == K:
        answer.append(visited[x])
        continue

    for co in (x - 1, x + 1, x * 2):
        if 0 <= co < 100001 and (not visited[co] or visited[co] == visited[x] + 1):
            visited[co] = visited[x] + 1
            q.append(co)

print(max(answer))
print(len(answer))
