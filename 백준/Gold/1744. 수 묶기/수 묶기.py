import sys

input = sys.stdin.readline

N = int(input())

plusNums = []
minusNums = []
result = 0
for _ in range(N):
    num = int(input())
    if num <= 0:
        minusNums.append(num)
    elif num > 1:
        plusNums.append(num)
    else:
        result += num

plusNums.sort(reverse=True)
minusNums.sort()


for i in range(0, len(minusNums), 2):
    if i + 1 >= len(minusNums):
        result += minusNums[i]
    else:
        result += (minusNums[i] * minusNums[i + 1])

for i in range(0, len(plusNums), 2):
    if i + 1 >= len(plusNums):
        result += plusNums[i]
    else:
        result += (plusNums[i] * plusNums[i + 1])

print(result)
