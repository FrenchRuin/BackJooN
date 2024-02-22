def solution(arr):
    answer = arr[0]
    
    def gcd(a,b) :
        if b==0 :
            return a
        return gcd(b,a%b)
    
    def lcm(a,b) :
        return (a * b) // gcd(a,b)
    
    for i in range(len(arr)) :
        answer = lcm(answer,arr[i])
    
    return answer