from itertools import combinations
import sys

input = sys.stdin.readline

N = int(input())  # Test Case
materials = [list(map(int, input().split())) for _ in range(N)]
answer = 1e9  # 100000000

for mat in [combinations(materials, i) for i in range(1, N + 1)]:
    for m in mat:
        S = 1
        B = 0
        for s, b in m:
            S *= s
            B += b
            answer = min(answer, abs(S - B))

print(answer)
