import sys
from collections import deque

def bfs(start):
    queue = deque()
    queue.append(start)

    while queue:
        start = queue.popleft()
        for next in graph[start]:
            if not visit[next]:
                queue.append(next)
                visit[next] = 1

N, M = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N+1)]
visit = [0] * (N+1)

for _ in range(M):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

cnt = 0
for i in range(1, N+1):
    if not visit[i]:
        bfs(i)
        cnt += 1

print(cnt)