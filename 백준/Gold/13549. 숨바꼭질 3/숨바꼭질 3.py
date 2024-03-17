import sys
from collections import deque
input = sys.stdin.readline

N,K = map(int,input().split())

visited = [0] * 100001



def bfs(V) :
  q = deque()
  if V == 0 :
    q.append(1)
  else:
    q.append(V)
  while q :
    V = q.popleft()

    if V == K :
      return visited[V]
    
    for i in (V - 1, V + 1, V * 2) :
      if 0<= i < 100001 and not visited[i] :
        if i == V*2 :
          visited[i] = visited[V]
          q.appendleft(i)
        else:
          visited[i] = visited[V] + 1
          q.append(i)
if N == 0 :
  print(bfs(N) + 1)
else:
  print(bfs(N))