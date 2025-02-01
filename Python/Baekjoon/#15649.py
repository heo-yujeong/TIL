import sys
input = sys.stdin.readline

def backtrack(cnt):
    if cnt == M:
        print(*result)
        return

    for i in range(1, N+1):
        if not visit[i]:
            visit[i] = 1
            result.append(i)
            backtrack(cnt+1)
            visit[i] = 0
            result.pop()

N, M = map(int, input().split())
visit = [0] * (N+1)
result = []

backtrack(0)