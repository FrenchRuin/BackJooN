import sys

input = sys.stdin.readline

N = int(input())
X, Y = map(int, input().split())
M = int(input())
graph = [[] for _ in range(N + 1)]
visited = [0] * (N + 1)
answer = []

for _ in range(M):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)


def dfs(V, num):
    if V == Y:
        answer.append(num)

    for i in graph[V]:
        if not visited[i]:
            visited[i] = 1
            dfs(i, num + 1)


dfs(X, 0)
print(answer[0] if len(answer) == 1 else -1)
