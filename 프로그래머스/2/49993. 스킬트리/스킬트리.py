def solution(skill, skill_trees):
    answer = 0
    
    for skill_tree in skill_trees :
        ch = ''
        for s in skill_tree :
            if s in skill :
                ch += s
        
        if skill[:len(ch)] == ch :
            answer += 1
    
    return answer