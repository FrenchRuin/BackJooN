import sys

input = sys.stdin.readline

N,M = map(int,input().split())
visited = [False] * N
arr = [0] * M

def recur(idx, depth):
  if depth == M :
    print(' '.join(map(str,arr)))
    return

  for i in range(idx, N):
    if visited[i] is False:
      visited[i] = True
      arr[depth] = i + 1
      recur(i, depth + 1)
      visited[i] = False

recur(0,0)
      