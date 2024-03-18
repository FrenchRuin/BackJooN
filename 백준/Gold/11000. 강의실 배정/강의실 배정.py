import sys
import heapq

"""
3
1 3
2 4
3 5

(1,3),(2,4),(3,5)
"""
input = sys.stdin.readline

N = int(input())
lectures = []
for _ in range(N):
    S, T = map(int, input().split())
    lectures.append([S, T])

lectures.sort(key=lambda x: (x[0], x[1]))

heap = [lectures[0][1]]

for i in range(1, N):
    if heap[0] <= lectures[i][0]:
        heapq.heappop(heap)
    heapq.heappush(heap, lectures[i][1])

print(len(heap))
