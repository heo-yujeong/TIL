import sys
from heapq import heappush, heappop
input = sys.stdin.readline

V, E = map(int, input().split())
graph = [[] for _ in range(V+1)]
visit = [0] * (V+1)

for _ in range(E):
    A, B, C = map(int, input().split())
    graph[A].append((C, B))
    graph[B].append((C, A))

result = 0
pq = [(0, 1)]

while pq:
    w, now = heappop(pq)
    if visit[now]:
        continue

    visit[now] = 1
    result += w

    for dw, next in graph[now]:
        if not visit[next]:
            heappush(pq, (dw, next))

print(result)