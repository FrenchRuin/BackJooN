def solution(brown, yellow):
    answer = []
    xy = brown + yellow 
    for x in range(1, xy + 1) :
        if (xy / x) % 1 == 0 :
            y = xy //x
            if x >= y and x*2 + y*2 == brown + 4 :
                answer = [x,y]
    return answer