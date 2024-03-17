import sys

input = sys.stdin.readline

N = int(input())
M = int(input())

graph = [i for i in range(N + 1)]
values = []


def union_find(V):
    if V != graph[V]:
        graph[V] = union_find(graph[V])
    return graph[V]


def union(X, Y):
    X = union_find(X)
    Y = union_find(Y)
    if X < Y:
        graph[Y] = X
    else:
        graph[X] = Y


for i in range(M):
    a, b, c = map(int, input().split())
    values.append((c, a, b))  # 비용 a,b

values.sort()
answer = 0
for c, a, b in values:
    if union_find(a) != union_find(b):
        union(a, b)
        answer += c

print(answer)
