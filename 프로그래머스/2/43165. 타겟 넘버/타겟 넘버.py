

def solution(numbers, target):
    global answer
    answer = 0
    
    dfs(0,numbers,target,0)
    
    return answer


def dfs(depth, numbers, target, sum) :
    global answer 
    
    if depth == len(numbers) :
        if target == sum :
            answer += 1
        return
    
    dfs(depth + 1, numbers, target, sum - numbers[depth])
    dfs(depth + 1, numbers, target, sum + numbers[depth])
    