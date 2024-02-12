N = int(input())

homes = []
for _ in range(N):
    homes.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x,y):
    if x <0 or x >= N or y < 0 or y >= N:
        return False
    if homes[x][y] == 1:
        global count
        count += 1
        homes[x][y] = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            dfs(nx,ny)
        return True
    return False

count = 0
answer = []

for i in range(N):
    for j in range(N):
        if dfs(i,j):
            answer.append(count)
            count = 0

answer.sort()
print(len(answer))
for i in answer:
    print(i)

