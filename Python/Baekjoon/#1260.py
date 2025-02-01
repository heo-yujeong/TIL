from collections import deque

def dfs(start):
    visited_dfs[start] = 1
    print(start, end=' ')

    for next in range(N+1):
        if visited_dfs[next] == 0 and graph[start][next] == 1:
            dfs(next)

def bfs(start):
    queue = deque()
    queue.append(start)
    visited_bfs[start] = 1

    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for next in range(N+1):
            if visited_bfs[next] == 0 and graph[v][next] == 1:
                queue.append(next)
                visited_bfs[next] = 1


N, M, V = map(int, input().split())

graph = [[0] * (N+1) for _ in range(N+1)]
for _ in range(M):
    s, e = map(int, input().split())
    graph[s][e] = 1
    graph[e][s] = 1
visited_dfs = [0] * (N+1)
visited_bfs = [0] * (N+1)

dfs(V)
print()
bfs(V)