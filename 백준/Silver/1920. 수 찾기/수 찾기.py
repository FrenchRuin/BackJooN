import sys

N = int(sys.stdin.readline())

Numbers = list(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())

Target = list(map(int, sys.stdin.readline().split()))

_dict = {}
for i in range(N):
    _dict[Numbers[i]] = 0

for j in range(len(Target)):
    if Target[j] not in _dict:
        print(0)
    else:
        print(1)