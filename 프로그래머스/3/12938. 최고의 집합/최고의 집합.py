import math

def solution(n, s):
    answer = []
    
    if s < n :
        return [-1]
    
    div = s // n
    left = s%n
    
    for i in range(n):
        answer.append(div)
        
    
    if left != 0 :
        for i in range(len(answer)) :
            answer[i] += 1
            left -= 1
            if left == 0 :
                break
    
    answer.sort()
    
    return answer