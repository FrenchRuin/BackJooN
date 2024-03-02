import sys

input = sys.stdin.readline

N = int(input())

graph = [0]
for _ in range(N):
  graph.append(int(input()))

result = []


def dfs(V, i):
  visited[V] = 1
  num = graph[V]
  if not visited[num]:
    dfs(num, i)
  elif visited[num] and num == i:
    result.append(num)


for i in range(1, N + 1):
  visited = [0] * (N + 1)
  dfs(i, i)

result.sort()
print(len(result))
for r in result:
  print(r)
