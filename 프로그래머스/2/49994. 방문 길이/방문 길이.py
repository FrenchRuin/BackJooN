def solution(dirs):
    answer = 0
    
    
    move = set()
    x,y = 0,0
    
    for di in dirs :
        if di == "U" and y < 5 :
            move.add(((x,y),(x,y + 1)))
            y += 1
        elif di == "D" and y > -5 :
            move.add(((x,y-1),(x,y)))
            y -= 1
        elif di == "L" and x > -5 :
            move.add(((x-1,y),(x,y)))
            x -= 1
        elif di == "R" and x < 5:
            move.add(((x,y),(x+1,y)))
            x += 1
    
    
    return len(move)