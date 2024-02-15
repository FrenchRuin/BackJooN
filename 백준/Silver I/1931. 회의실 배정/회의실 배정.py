import sys

input = sys.stdin.readline

N = int(input())

conference = [list(map(int, input().split())) for _ in range(N)]
conference.sort(key=lambda x: (x[1], x[0]))


count = 0
endPoint = 0
for start, end in conference:
    if endPoint <= start:
        count += 1
        endPoint = end

print(count)
