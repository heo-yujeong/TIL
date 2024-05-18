import sys
input = sys.stdin.readline

def dfs(now, cnt):
    visit[now] = 1
    for next in graph[now]:
        if not visit[next]:
            cnt = dfs(next, cnt+1)
    return cnt

T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    graph = [[] for _ in range(N+1)]
    visit = [0] * (N+1)

    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    print(dfs(1, 0))