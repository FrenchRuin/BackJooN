def solution(s):
    answer = 0
    for i in range(len(s)) :
        arr = []
        target = s[i:] + s[:i]
        for j in target :
            if len(arr) == 0 :
                arr.append(j)
            elif j == ')' and arr[-1] == '(' :
                arr.pop()
            elif j == ']' and arr[-1] == '[' :
                arr.pop()
            elif j == '}' and arr[-1] == '{' :
                arr.pop()
            else :
                arr.append(j)
        if len(arr) == 0 :
            answer += 1
                
    return answer