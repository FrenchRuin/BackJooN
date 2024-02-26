def solution(s):
    answer = ''
    ll = list(map(int,s.split()))
    return str(min(ll)) + ' ' + str(max(ll))