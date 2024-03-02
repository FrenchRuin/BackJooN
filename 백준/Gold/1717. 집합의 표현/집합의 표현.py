import sys

input = sys.stdin.readline
sys.setrecursionlimit(1000000)

N, M = map(int, input().split())

graph = [0] * (N + 1)

for i in range(1, N + 1):
    graph[i] = i


def union_find(V):
    if V != graph[V]:
        graph[V] = union_find(graph[V])
    return graph[V]


def union(a, b):
    a = union_find(a)
    b = union_find(b)
    if a > b:
        graph[a] = b
    else:
        graph[b] = a


for i in range(1, M + 1):
    T, A, B = map(int, input().split())
    if T == 0:
        union(A, B)
    else:
        if union_find(A) != union_find(B) :
            print("NO")
        else:
            print("YES")
