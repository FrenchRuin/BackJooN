def solution(s):
    answer = []
    
    sli = s[2:-2].split("},{")
    sli.sort(key=len)
    
    for st in sli :
        target = st.split(",")
        for i in target : 
            if int(i) not in answer :
                answer.append(int(i))
    
    
    
    return answer