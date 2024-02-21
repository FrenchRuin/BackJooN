import math
from itertools import permutations

def solution(numbers) :
    answer = 0
    
    nums = []
    for i in range(1, len(numbers) + 1) :
        nums += list(permutations(numbers, i))
    
    new_nums = [int(''.join(x)) for x in nums ]
    new_nums = set(new_nums)

    answer = []
    for n in new_nums :
        if is_prime(n) :
            answer.append(n)
            
        
    return len(answer) 


def is_prime(n) :
    if n<2 :
        return False
    
    for i in range(2, int(math.sqrt(n)) + 1) :
        if n % i == 0 :
            return False
        
    return True