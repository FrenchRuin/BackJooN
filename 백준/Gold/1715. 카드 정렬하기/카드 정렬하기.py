import sys
import heapq

input = sys.stdin.readline

N = int(input())
cards = []
"""
정렬후, 2묶음씩 더한것을 큐에 넣어준후, 모두 더해주면? 되지않는가....
"""

for _ in range(N):
    num = int(input())
    heapq.heappush(cards, num)

answer = 0
while len(cards) > 1:
    a = heapq.heappop(cards)
    b = heapq.heappop(cards)
    sums = a + b
    answer += sums
    heapq.heappush(cards, sums)

print(answer)
