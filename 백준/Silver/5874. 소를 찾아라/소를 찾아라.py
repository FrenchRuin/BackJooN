import sys

input = sys.stdin.readline

data = input()

count = 0
answer = 0
for i in range(1, len(data) - 1):
    if data[i] == data[i - 1]:
        if data[i] == '(':
            count += 1
        else:
            answer += count

print(answer)