import sys

input = sys.stdin.readline

N,M = map(int,input().split())
arr = [0] * M

def recur( depth):
  if depth == M :
    print(' '.join(map(str,arr)))
    return

  for i in range(N):
    arr[depth] = i + 1
    recur(depth + 1)

recur(0)
      