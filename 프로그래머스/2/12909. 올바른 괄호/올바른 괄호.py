def solution(s):
    answer = True
    
    st = []
    for char in s :
        if char == '(' :
            st.append('(')
        else:
            if st :
                st.pop()
            else:
                return False
    
    if st :
        return False

    return True