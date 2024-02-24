from itertools import permutations

def solution(user_id, banned_id):
    userList = list(permutations(user_id, len(banned_id)))
    
    def checkValidation(users, banned_id) :
        for i in range(len(banned_id)) :
            if len(users[i]) != len(banned_id[i]) :
                return False
            
            for j in range(len(users[i])) :
                if banned_id[i][j] == '*' :
                    continue
                
                if users[i][j] != banned_id[i][j] :
                    return False
        return True
    
    bans = []
    for users in userList :
        if not checkValidation(users, banned_id) :
            continue
        else:
            users = set(users)
            if users not in bans :
                bans.append(users)
                
    return len(bans)