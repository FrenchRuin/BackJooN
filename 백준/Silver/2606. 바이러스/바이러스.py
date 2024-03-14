import sys

input = sys.stdin.readline

N = int(input())
computers = [0]
for i in range(1, N + 1):
    computers.append(i)


def union_find(x):
    if x != computers[x]:
        computers[x] = union_find(computers[x])

    return computers[x]


def union(a, b):
    a = union_find(a)
    b = union_find(b)

    if a < b:
        computers[b] = computers[a]
    else:
        computers[a] = computers[b]


M = int(input())
for _ in range(M):
    a, b = map(int, input().split())
    union(a, b)

answer = 0
for i in range(2, N + 1):
    if union_find(i) == 1 :
        answer += 1

print(answer)
