import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

q = deque()

for _ in range(1, N + 1):
    q.append(_)

"""
1 2 3 4 5 6 7
4 5 6 7 1 2 3 
7 1 2 3 4 5 6
3 4 5 6 7 1 2
6 7 1 2 3 4 5
2 3 4 5 6 7 1
"""
answer = []
while q:
    for i in range(K - 1):
        q.append(q.popleft())
    answer.append(q.popleft())

str = '<' + ', '.join(map(str, answer)) + '>'
print(str)
