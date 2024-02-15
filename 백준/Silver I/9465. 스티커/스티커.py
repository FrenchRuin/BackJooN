import sys

input = sys.stdin.readline

T = int(input())

for t in range(T):
    N = int(input())  # N
    sticker = [[0] * (N + 1) for _ in range(2)]
    for i in range(2):  # sticker 생성
        sticker[i] = [0] + list(map(int, input().split()))

    for i in range(2, N + 1):
        sticker[0][i] = max(sticker[1][i - 1], sticker[1][i - 2]) + sticker[0][i]
        sticker[1][i] = max(sticker[0][i - 1], sticker[0][i - 2]) + sticker[1][i]

    print(max(sticker[0][N], sticker[1][N]))
