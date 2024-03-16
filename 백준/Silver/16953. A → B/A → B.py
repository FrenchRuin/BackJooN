import sys

input = sys.stdin.readline

A, B = map(int, input().split())
cnt = 0
while B != A:

    if B < 2:
        cnt = 0
        break

    if B % 2 == 0:
        B //= 2
        cnt += 1
    else:
        tmp = str(B)[-1]
        if tmp == '1':
            B = int(str(B)[:len(str(B)) - 1])
            cnt += 1
        else:
            cnt = 0
            break

print(cnt + 1 if cnt >= 1 else -1)
