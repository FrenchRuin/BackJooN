def solution(want, number, discount):
    answer = 0
    
    wantDict = dict()
    # dictionary 사용
    for i in range(len(want)) :
        wantDict[want[i]] = number[i]
    
    for i in range(len(discount)) :
        check = True
        if i == len(discount) - 9 :
            break
        
        discountDict = dict()
        for j in range(i, i + 10) :
            discountDict[discount[j]] = discountDict.get(discount[j], 0) + 1
            
        for j in range(len(want)) :
            if wantDict.get(want[j], -1) !=  discountDict.get(want[j] , 0) :
                check = False
                break
        
        if check :
            answer += 1
            
    return answer