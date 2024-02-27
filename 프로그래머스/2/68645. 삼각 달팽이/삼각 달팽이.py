"""
2차원배열로 간다.
"""

def solution(n):
    answer = []
    snails = [[0] * n for _ in range(n)]
    x,y = -1, 0
    num = 1
    for i in range(n) :
        for j in range(i , n) :
            if i % 3 == 0 :
                x += 1
            elif i % 3 == 1 :
                y += 1
            else:
                x -= 1
                y -= 1
            
            snails[x][y] = num
            num += 1
    
    for i in range(n) :
        for j in range(i + 1) :
            answer.append(snails[i][j])
    
    return answer