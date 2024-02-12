import sys
from collections import deque

input = sys.stdin.readline

N,M,V = map(int,input().split())

graph = [[False] * (N + 1) for _ in range(N + 1)]

for _ in range(M) :
  a,b  = map(int,input().split())
  graph[a][b] = graph[b][a] = True

visitedForBfs = [False] * (N + 1)
visitedForDfs = [False] * (N + 1)


  
def dfs(V) :
  visitedForDfs[V] = True
  print(V, end=" ")
  for i in range(1, N+1):
    if not visitedForDfs[i] and graph[V][i]:
      dfs(i)

def bfs(V) :
  queue = deque()
  queue.append(V)
  visitedForBfs[V] = True
  while queue :
    V = queue.popleft()
    print(V, end=" ")
    for i in range(1, N + 1):
      if not visitedForBfs[i] and graph[V][i]:
        queue.append(i)
        visitedForBfs[i] = True


dfs(V)
print()
bfs(V)