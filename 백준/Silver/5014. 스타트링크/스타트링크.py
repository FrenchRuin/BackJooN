import sys
from collections import deque

input = sys.stdin.readline

F, S, G, U, D = map(int, input().split())

visited = [False] * (F + 1)
count = [0] * (F + 1)


def bfs(V):
    queue = deque([V])
    visited[V] = True
    while queue:
        V = queue.popleft()

        if V == G:
            return count[G]

        for i in (V + U, V - D):
            if 1 <= i <= F and not visited[i]:
                visited[i] = True
                count[i] = count[V] + 1
                queue.append(i)

    if count[G] == 0:
        return "use the stairs"


print(bfs(S))
