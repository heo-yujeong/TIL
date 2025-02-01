import sys
from heapq import heappush, heappop
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
visit = [0] * (N+1)

for _ in range(M):
    A, B, C = map(int, input().split())
    graph[A].append((C, B))
    graph[B].append((C, A))

hap = 0
cost = 0
pq = [(0, 1)]

while pq:
    fee, now = heappop(pq)
    if visit[now]:
        continue

    visit[now] = 1
    hap += fee
    cost = max(cost, fee)

    for f, next in graph[now]:
        if not visit[next]:
            heappush(pq, (f, next))

print(hap - cost)