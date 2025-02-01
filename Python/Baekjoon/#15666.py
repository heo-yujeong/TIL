import sys
input = sys.stdin.readline

def backtrack(cnt):
    if cnt == M:
        result.add(tuple(tmp))
        return

    for i in range(N):
        if not tmp or (tmp and tmp[-1] <= num_lst[i]):
            tmp.append(num_lst[i])
            backtrack(cnt+1)
            tmp.pop()

N, M = map(int, input().split())
num_lst = list(map(int, input().split()))
num_lst.sort()

tmp = []
result = set()

backtrack(0)
result = list(result)
result.sort()

for res in result:
    print(*res)