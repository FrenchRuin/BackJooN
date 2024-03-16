import sys
import heapq

input = sys.stdin.readline

N = int(input())

command = []

for _ in range(N):
    com = int(input())
    if com == 0:
        if len(command) == 0:
            print(0)
        else:
            print(-heapq.heappop(command))
    else:
        heapq.heappush(command, -com)
