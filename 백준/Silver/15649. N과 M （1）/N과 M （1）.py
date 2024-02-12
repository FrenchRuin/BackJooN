import sys

input = sys.stdin.readline

N,M = map(int, input().split())

visited = [False] * N
arr = [0] * M

def dfs(depth):
  if depth == M :
    print(' '.join(map(str,arr)))
    return

  for i in range(N):
    if visited[i] is False:
      visited[i] = True
      arr[depth] = i + 1
      dfs(depth+1)
      visited[i] = False

dfs(0)