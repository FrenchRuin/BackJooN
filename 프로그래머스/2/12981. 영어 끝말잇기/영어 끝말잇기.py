def solution(n, words):
    answer = []
    already = set()
    for i in range(len(words)) :
        if len(already) == 0 :
            already.add(words[i])
        elif words[i] in already :
            return [ (i % n) + 1, (i // n) + 1]
        else:
            if words[i-1][-1] == words[i][0] :
                already.add(words[i])
            else:
                return [ (i % n) + 1, (i // n) + 1]
            
    
    return [0,0]