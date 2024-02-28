import sys

input = sys.stdin.readline
N = int(input())

eggs = [list(map(int, input().split())) for _ in range(N)]


def checkCrack(eggs):
    global answer
    cnt = 0
    for e in eggs:
        if e[0] <= 0:
            cnt += 1
    answer = max(answer, cnt)


def dfs(depth, eggs):
    if depth == N:
        checkCrack(eggs)
        return

    if eggs[depth][0] <= 0:
        dfs(depth + 1, eggs)
        return

    check = True
    for i in range(N):
        if depth == i: continue
        if eggs[i][0] > 0: check = False

    if check:
        checkCrack(eggs)
        return

    for i in range(N):
        if depth == i: continue
        if eggs[i][0] <= 0: continue

        eggs[depth][0] -= eggs[i][1]
        eggs[i][0] -= eggs[depth][1]
        dfs(depth + 1, eggs)
        eggs[depth][0] += eggs[i][1]
        eggs[i][0] += eggs[depth][1]


answer = 0
dfs(0, eggs)
print(answer)
