from collections import deque

def solution(tickets):
    answer = []
    
    visited = [0] * len(tickets)
    
    def dfs(airport, path) :
        
        if len(path) == len(tickets) + 1 :
            answer.append(path)
            return
        
        for idx, ticket in enumerate(tickets) :
            if ticket[0] == airport and not visited[idx] :
                visited[idx] = 1
                dfs(ticket[1], path + [ticket[1]])
                visited[idx] = 0
        
    dfs("ICN",["ICN"])
    answer.sort()
    return answer[0]