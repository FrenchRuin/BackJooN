import sys

input = sys.stdin.readline

N,M = map(int,input().split())

buildings = [0] * (N + 1)


def findParent(V) :
  if buildings[V] != V :
    buildings[V] = findParent(buildings[V])
    
  return buildings[V]

def union(A,B) :
  A = findParent(A)
  B = findParent(B)
  if A> B :
    buildings[A] = B
  else:
    buildings[B] = A


for i in range(1,N + 1) :
  buildings[i] = i

for _ in range(M) :
  A,B = map(int,input().split())
  union(A,B)

plans = list(map(int,input().split()))

answer = 0
for i in range(1, len(plans)) :
  if findParent(plans[i-1]) != findParent(plans[i]) :
    answer += 1

print(answer)
