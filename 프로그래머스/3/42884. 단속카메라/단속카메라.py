def solution(routes):
    answer = 0
    
    routes.sort(key=lambda x : x[1])
    
    c = -30001
    
    for r in routes : 
        if c < r[0] :
            answer += 1
            c = r[1]
    
    return answer