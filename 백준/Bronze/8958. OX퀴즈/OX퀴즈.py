import sys

T = int(sys.stdin.readline())

for k in range(T):
    result = sys.stdin.readline()
    score = 0
    acc_score = 0
    for i in result:
        if i == 'O':
            acc_score += 1
            score += acc_score
        if i == 'X':
            acc_score = 0
    print(score)