import sys

input = sys.stdin.readline
def dfs(v, i):
    visited[v] = 1
    num = graph[v]
    if not visited[num]:
        dfs(num, i)
    elif visited[num] and num == i:
        result.append(num)


N = int(input())
graph = [0] + [int(input()) for _ in range(N)]

result = []

for i in range(1, N + 1):
    visited = [0] * (N + 1)
    dfs(i, i)

result.sort()
print(len(result))
for r in result:
    print(r)
