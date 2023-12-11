def solution(s):
    answer = []
    
    for i in range(len(s)) :
        if len(answer) == 0 :
            answer.append(s[i])
        elif answer[-1] == s[i] :
            answer.pop()
        else :
            answer.append(s[i])

    return 1 if len(answer) == 0 else 0