import sys
from collections import deque

input = sys.stdin.readline

def bfs(v):
  queue = deque()
  queue.append(v)
  while queue :
    v = queue.popleft()
    if v == K :
      return array[v]
    for nv in (v-1,v+1,v*2) :
      if 0<= nv < MAX and not array[nv] :
        array[nv] = array[v] + 1
        queue.append(nv)


N,K = map(int,input().split())
MAX = 100001
array = [0] * MAX

print(bfs(N))