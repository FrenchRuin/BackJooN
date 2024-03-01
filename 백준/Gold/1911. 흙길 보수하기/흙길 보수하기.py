import sys

input = sys.stdin.readline

N, L = map(int,input().split())

ponds = sorted(tuple(map(int,input().split())) for _ in range(N))


answer, s = 0,0
for start, end in ponds :
  s = max(start,s)
  diff = end - s
  count = (diff + L - 1) // L
  answer += count
  s += count * L

print(answer)
  