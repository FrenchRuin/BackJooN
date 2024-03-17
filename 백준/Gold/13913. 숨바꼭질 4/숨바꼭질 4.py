import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

visited = [0] * 100001
check = [0] * 100001


def move(V):
  data = []
  temp = V
  for _ in range(visited[V] + 1):
    data.append(temp)
    temp = check[temp]
  print(' '.join(map(str, data[::-1])))


q = deque()
q.append(N)

while q:
  V = q.popleft()

  if V == K:
    print(visited[V])
    move(V)
    break

  for i in (V - 1, V + 1, V * 2):
    if 0 <= i < 100001 and not visited[i]:
      visited[i] = visited[V] + 1
      q.append(i)
      check[i] = V
