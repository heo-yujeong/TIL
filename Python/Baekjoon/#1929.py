import math

def isSosu(num):
    for i in range(2, int(math.sqrt(num))+1):
        if num % i == 0:
            return False
    else:
        return True

M, N = map(int, input().split())

for i in range(M, N+1):
    if i == 1:
        continue
    if isSosu(i):
        print(i)