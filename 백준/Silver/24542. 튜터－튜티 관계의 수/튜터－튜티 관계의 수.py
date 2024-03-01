import sys
from collections import deque

input = sys.stdin.readline

N,M = map(int, input().split())

graph = [ [] for _ in range(N + 1)]

for _ in range(M) :
  a,b = map(int,input().split())
  graph[a].append(b)
  graph[b].append(a)

visited = [0] * (N + 1)

def bfs(V) :
  queue = deque()
  queue.append(V)
  cnt = 1
  visited[V] = 1
  while queue :
    V = queue.popleft()
    for gr in graph[V] :
      if not visited[gr] :
        visited[gr] = 1
        queue.append(gr)
        cnt += 1

  return cnt

answer = 1
for i in range(1, N + 1) :
  if not visited[i] :
    answer *= bfs(i)


print(answer%1000000007)

