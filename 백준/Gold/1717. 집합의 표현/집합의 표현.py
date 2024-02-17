import sys

input = sys.stdin.readline
sys.setrecursionlimit(1000000)
N, M = map(int, input().split())

joint = [0] * (N + 1)

for i in range(1, N + 1):
    joint[i] = i


def union_find(V):
    if V != joint[V]:
        joint[V] = union_find(joint[V])

    return joint[V]


def union(A, B):
    A = union_find(A)
    B = union_find(B)

    if A > B:
        joint[A] = B
    else:
        joint[B] = A


for i in range(1, M + 1):
    T, A, B = map(int, input().split())
    if T == 0:
        union(A, B)
    elif T == 1:
        if union_find(joint[A]) == union_find(joint[B]):
            print("YES")
        else:
            print("NO")
