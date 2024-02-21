def solution(k, dungeons):
    global answer
    answer = -1 
    visited = [False] * len(dungeons)
    dfs(dungeons, visited, k , 0)
    return answer


def dfs(dungeons, visited, k, cnt) :
    global answer 
    for i in range(len(dungeons)) :
        if not visited[i] and dungeons[i][0] <= k :
            visited[i] = True
            dfs(dungeons, visited, k - dungeons[i][1], cnt + 1)
            visited[i] = False
    
    answer = max(answer,cnt)
    