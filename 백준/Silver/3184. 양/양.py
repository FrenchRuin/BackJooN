import sys
from collections import deque

R, C = map(int, input().split())

maps = [list(map(str, input())) for _ in range(R)]

visited = [[False] * C for _ in range(R)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

sheepAnswer = 0
wolfAnswer = 0


def bfs(x, y):
    global sheep
    global wolf
    wolf = 0
    sheep = 0
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < R and 0 <= ny < C:
                if maps[nx][ny] != '#' and not visited[nx][ny]:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
                    if maps[nx][ny] == 'v':
                        wolf += 1
                    elif maps[nx][ny] == 'o':
                        sheep += 1
    if sheep > wolf:
        wolf = 0
    else:
        sheep = 0


wolf = 0
sheep = 0
for i in range(R):
    for j in range(C):
        bfs(i, j)
        sheepAnswer += sheep
        wolfAnswer += wolf

print(sheepAnswer, wolfAnswer)
