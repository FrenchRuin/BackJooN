def solution(s):
    stack = []
    for c in range(len(s)) :
        if len(stack) == 0 :
            stack.append(s[c])
        elif s[c] == '(' :
            stack.append(s[c])
        elif s[c] == ')' :
            stack.pop()

    if len(stack) != 0 :
        answer = False
    else : 
        answer = True
        
    return answer