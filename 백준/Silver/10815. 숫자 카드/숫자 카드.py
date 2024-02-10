import sys

N = int(sys.stdin.readline())
Cards = list(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())
Target = list(map(int, sys.stdin.readline().split()))

_dict = {}
for i in range(len(Cards)):
    _dict[Cards[i]] = 0

for j in range(M):
    if Target[j] not in _dict:
        print(0, end=" ")
    else:
        print(1, end=" ")