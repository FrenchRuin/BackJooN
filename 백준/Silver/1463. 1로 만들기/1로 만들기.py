X = int(input())
count = 0
def recur(X, count):
    if X < 2 :
        return count
    return min(recur(X//2 , count + 1 + (X % 2)), recur(X//3 , count + 1 + (X % 3)))

print(recur(X, count))