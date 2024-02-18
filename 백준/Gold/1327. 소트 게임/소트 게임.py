import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())  # N = 순열의 크기 , K = 뒤집어야할 숫자 갯수
arr = list(map(str, input().split()))  # 현재 순열
target = sorted(arr)  # 정렬된 순열
answer = -1  # 답을 찾지 못했을 경우
visited = set("".join(arr))

queue = deque()
queue.append([arr, 0])

while queue:
    arr, cnt = queue.popleft()
    if arr == target:  # 정렬한 순열이 오름차순으로 되어있다면
        answer = cnt
        break

    for i in range(N - K + 1):
        arrToReverse = arr[i:i + K]
        arrToReverse.reverse()  # 변경된 순열
        arrFront = arr[:i]  # 변경되고 나머지 앞쪽의 순열
        arrBack = arr[i + K:]  # 변경되고 나머지 뒤쪽의 순열
        arrToCheck = arrFront + arrToReverse + arrBack  # 배열 합침
        arrToString = "".join(arrToCheck)  # string으로 변환
        if arrToString not in visited:  # set에 string으로 변환한 배열이 없다면
            visited.add(arrToString)  # visited 추가
            queue.append([arrToCheck, cnt + 1])  # queue append (합친 배열과 횟수 증가 )

print(answer)
