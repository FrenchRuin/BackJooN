def solution(n, words):
    answer = [1,1]
    strList = []
    chk = True
    strList.append(words[0])
    
    for i in range(1, len(words)) :
        if((words[i][:1] != words[i-1][-1]) or (strList.count(words[i]) > 0)) :
            answer[0] = (i % n) + 1
            answer[1] = (i // n) + 1
            chk = False
            break
        strList.append(words[i])
    
    return answer if chk == False else [0,0]