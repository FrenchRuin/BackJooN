import sys

input = sys.stdin.readline

N = int(input())

lines = [list(map(int, input().split())) for _ in range(N)]

lines.sort()

start = lines[0][0]
end = lines[0][1]
answer = 0
for i in range(1, N):
    new_start = lines[i][0]
    new_end = lines[i][1]

    if end > new_start:
        end = max(end, new_end)
    else:
        answer += (end - start)
        start = new_start
        end = new_end

answer += (end - start)
print(answer)
