def solution(k, tangerine):
    answer = 0
    list = {}
    for i in tangerine : 
        if i in list : 
            list[i] += 1
        else :
            list[i] = 1
    list = dict(sorted(list.items(), key=lambda x: x[1], reverse = True))
    for i in list : 
        if k<= 0 :
            return answer
        k -= list[i]
        answer += 1
    
    return answer