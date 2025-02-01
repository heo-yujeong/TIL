import sys
input = sys.stdin.readline

def backtrack(cnt):
    if cnt == M:
        print(*result)
        return

    for i in range(N):
        if not result or (result and result[-1] <= num_lst[i]):
            result.append(num_lst[i])
            backtrack(cnt+1)
            result.pop()


N, M = map(int, input().split())
num_lst = list(map(int, input().split()))
num_lst.sort()

result = []

backtrack(0)