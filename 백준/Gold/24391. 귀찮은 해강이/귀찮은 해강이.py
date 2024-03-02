import sys

input = sys.stdin.readline

N, M = map(int, input().split())

graph = [0] * (N + 1)
for i in range(1, N + 1):
  graph[i] = i


def union_find(V):
  if V != graph[V]:
    graph[V] = union_find(graph[V])

  return graph[V]


def union(A, B):
  A = union_find(A)
  B = union_find(B)
  if A > B:
    graph[A] = B
  else:
    graph[B] = A


for _ in range(M):
  A, B = map(int, input().split())
  union(A, B)

plans = list(map(int, input().split()))

cnt = 0
for i in range(1, len(plans)):
  if union_find(plans[i - 1]) != union_find(plans[i]):
    cnt += 1

print(cnt)