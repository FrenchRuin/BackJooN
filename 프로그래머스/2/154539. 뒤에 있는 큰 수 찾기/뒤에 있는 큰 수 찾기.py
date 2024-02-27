def solution(numbers):
    answer = [0] * len(numbers)
    st = []    
    
    for i in range(len(numbers)) :
        while(len(st) != 0 and numbers[st[-1]] < numbers[i]) :
            answer[st.pop()] = numbers[i]
        
        st.append(i)
        
    while(len(st) != 0) :
        answer[st.pop()] = -1
    
    return answer