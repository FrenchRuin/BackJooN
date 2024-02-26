def solution(s):
    answer = -1
    ll = []
    
    for char in s :
        if len(ll) == 0 :
            ll.append(char)
        elif ll[-1] == char :
            ll.pop()
        else:
            ll.append(char)

    
    return 1 if len(ll) == 0 else 0