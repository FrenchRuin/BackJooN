import sys

input = sys.stdin.readline

T = int(input())  # 테스트 케이스


def binary_search(target, data):
    start = 0
    end = len(data) - 1
    result = -1
    while start <= end:
        mid = (start + end) // 2
        if data[mid] < target:
            result = mid
            start = mid + 1
        else:
            end = mid - 1
    return result


for _ in range(T):

    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    count = 0

    A.sort()
    B.sort()

    for a in A:
        count += binary_search(a, B) + 1

    print(count)

