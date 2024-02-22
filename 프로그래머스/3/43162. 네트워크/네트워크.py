def solution(n, computers):
    answer = 0
    
    visited = [0] * n
    
    for i in range(n) :
        if not visited[i] :
            answer += 1
            dfs(visited,n, computers,i)
            
    return answer


def dfs(visited, n, computers, i) :
    visited[i] = 1
    
    for j in range(n) :
        if not visited[j] and computers[i][j] == 1 :
            dfs(visited, n, computers, j)
    