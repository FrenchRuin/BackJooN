from itertools import product
def solution(word):
    answer = 0
    result = []
    for r in range(1,6) :
        for li in (product(["A","E","I","O","U"], repeat = r)) :
            result.append(''.join(k for k in li))
    
    result.sort()
    return result.index(word) + 1