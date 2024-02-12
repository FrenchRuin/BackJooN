from collections import deque

N = int(input())

homes = []
for _ in range(N):
    homes.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(homes, x, y):
    queue = deque()
    queue.append((x, y))
    homes[x][y] = 0
    count = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if homes[nx][ny] == 1:
                homes[nx][ny] = 0
                queue.append((nx, ny))
                count += 1
    return count


answer = []
for i in range(N):
    for j in range(N):
        if homes[i][j] == 1:
            answer.append(bfs(homes, i, j))
answer.sort()
print(len(answer))
for i in answer:
    print(i)

