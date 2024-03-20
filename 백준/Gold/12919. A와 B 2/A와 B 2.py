import sys

input = sys.stdin.readline

S = list(input().strip())
T = list(input().strip())


def dfs(V):
    if V == S:
        print(1)
        sys.exit()

    if len(V) == 0:
        return 0

    if V[-1] == 'A':
        dfs(V[:-1])
    if V[0] == 'B':
        dfs(V[1:][::-1])


dfs(T)
print(0)
