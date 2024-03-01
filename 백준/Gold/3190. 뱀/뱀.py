import sys
from collections import deque

input = sys.stdin.readline

# Map setting
N = int(input())
maps = [[0] * N for _ in range(N)]

# apple setting
K = int(input())
for _ in range(K):
    a, b = map(int, input().split())
    maps[a - 1][b - 1] = 1

# command settings
L = int(input())
command = []
for _ in range(L):
    data = input().split()
    command.append((int(data[0]), data[1]))

# last game
command.append((10001, ''))

# 오른쪽, 위, 왼쪽, 아래 순
directions = [(0, 1), (-1, 0), (0, -1), (1, 0)]


def turn_direction(direction):
    global turn_idx
    if direction == 'L':
        if turn_idx != 3:
            turn_idx += 1
        else:
            turn_idx = 0
    else:
        if turn_idx != 0:
            turn_idx -= 1
        else:
            turn_idx = 3
    return


snakes = deque()
snakes.append((0, 0))  # 시작
x, y = 0, 0  # 머리
start = 1
cnt = 0
turn_idx = 0  # 진행방향
flag = False
for i in range(len(command)):
    start = cnt + 1
    for _ in range(start, command[i][0] + 1):
        nx = x + directions[turn_idx][0]
        ny = y + directions[turn_idx][1]
        if nx < 0 or nx >= N or ny < 0 or ny >= N or (nx, ny) in snakes:
            cnt += 1
            flag = True
            break

        if maps[nx][ny] == 1:
            maps[nx][ny] = 0
            x, y = nx, ny
            snakes.append((x, y))
        else:
            x, y = nx, ny
            snakes.popleft()
            snakes.append((x, y))

        cnt += 1

    if flag:
        break

    turn_direction(command[i][1])

print(cnt)
