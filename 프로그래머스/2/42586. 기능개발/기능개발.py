def solution(progresses, speeds):
    answer = []
    days = 0
    count = 0
    while len(progresses) > 0 :
        if (progresses[0] + days * speeds[0]) >= 100 :
            progresses.pop(0)
            speeds.pop(0)
            count += 1
        else :
            if count > 0 :
                answer.append(count)
                count = 0
            else :
                days += 1
    answer.append(count)
    return answer