import sys
input = sys.stdin.readline

def backtrack(length, lst):
    if length == M:
        result.add(tuple(lst))
        return
    for i in range(N):
        if not check[i]:
            check[i] = 1
            backtrack(length+1, lst+[num_lst[i]])
            check[i] = 0

N, M = map(int, input().split())
num_lst = list(map(int, input().split()))
check = [0] * N

result = set()

backtrack(0, [])

result = list(result)
result.sort()
for r in result:
    print(*r)