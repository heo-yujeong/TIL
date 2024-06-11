import sys
from collections import deque
input = sys.stdin.readline

def bfs(start, end):
    queue = deque()
    queue.append([start, 0])
    visit = [1001*N*N] * (N+1)
    visit[start] = 0

    while queue:
        now, dist = queue.popleft()
        if visit[now] < dist:
            continue
        for next, d in graph[now]:
            if visit[next] > visit[now] + d:
                visit[next] = visit[now] + d
                queue.append([next, visit[next]])
    return visit[end]

N, E = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])
    graph[b].append([a, c])
v1, v2 = map(int, input().split())

path1 = bfs(1, v1) + bfs(v1, v2) + bfs(v2, N)
path2 = bfs(1, v2) + bfs(v2, v1) + bfs(v1, N)

if path1 >= 1001*N*N and path2 >= 1001*N*N:
    print(-1)
else:
    print(min(path1, path2))