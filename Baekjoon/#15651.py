def backtrack(cnt):
    if cnt == M:
        print(*result)
        return

    for i in range(1, N+1):
        result.append(i)
        backtrack(cnt+1)
        result.pop()

N, M = map(int, input().split())
result = []

backtrack(0)