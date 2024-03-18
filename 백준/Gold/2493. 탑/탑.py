import sys

"""
stack 에 인덱스와 값을 넣는다.
ex ) stack = [[0,1],[1,2]]

answer 에 index값을 넣어준다.

"""
input = sys.stdin.readline

N = int(input())

towers = list(map(int, input().split()))
stack = []
answer = []

for i in range(N):
    while stack:
        if stack[-1][1] > towers[i]:
            answer.append(stack[-1][0] + 1)
            break
        else:
            stack.pop()

    if len(stack) == 0:
        answer.append(0)

    stack.append([i, towers[i]])

print(' '.join(map(str, answer)))
