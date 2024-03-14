import sys

input = sys.stdin.readline

N, M = map(int, input().split())

D = set()
for _ in range(N):
    D.add(input().strip())

B = set()
for _ in range(M):
    B.add(input().strip())

answer = sorted(list(D & B))
print(len(answer))
for a in answer :
    print(a)