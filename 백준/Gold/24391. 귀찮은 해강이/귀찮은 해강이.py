"""
UNION Find 기초 문제다.

연결되어있는 건물이 존재하고,
수업시간표가 존재하면,

건물밖을 나와야한다.
그렇다면 수업을 듣기위해 최소 나와야하는 횟수를 구한다.

건물 5 / 연결되어있는건물 3 케이스
1번 3번
2번 5번
3번 4번 건물 연결

연결되어있는 건물들을 같은 집합으로 본다.
1,3,4

2,5

--
1 2 3 5 4 수업 시간표라고 가정한다면
1번건물에서 2번건물로 가는데
1번 건물과 2번건물이 다른집합일때 카운트를 플러스한다.
"""

import sys

input = sys.stdin.readline


def union_find(V):
    if V != buildings[V]:
        buildings[V] = union_find(buildings[V])
    return buildings[V]


def union(A, B):
    A = union_find(A)
    B = union_find(B)

    if A > B:
        buildings[A] = B
    else:
        buildings[B] = A


N, M = map(int, input().split())  # N -> 건물갯수 / M -> 연결되어있는 건물 케이스

buildings = [0] * (N + 1)  # 건물들

for i in range(1, N + 1):  # 1,2,3... 입력
    buildings[i] = i

# 연결되어있는 건물 입력
for i in range(M):
    A, B = map(int, input().split())
    union(A, B)

# 시간표
timeTable = list(map(int, input().split()))
answer = 0
for i in range(1, len(timeTable)):
    if union_find(timeTable[i - 1]) != union_find(timeTable[i]):
        answer += 1

print(answer)
