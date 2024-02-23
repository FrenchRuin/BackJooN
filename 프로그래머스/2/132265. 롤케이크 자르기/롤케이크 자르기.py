from collections import Counter

def solution(topping):
    dic = Counter(topping)
    answer = 0
    
    res_dic = set()
    
    for t in topping :
        dic[t] -= 1
        res_dic.add(t)
        
        if dic[t] == 0 :
            dic.pop(t)
        
        if len(dic) == len(res_dic) :
            answer += 1
        
    
    
    return answer