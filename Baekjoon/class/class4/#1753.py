import sys
from heapq import heappush, heappop
input = sys.stdin.readline

def bfs(start):
    pq = []
    heappush(pq, (0, start))
    visit[start] = 0

    while pq:
        dist, now = heappop(pq)
        if visit[now] < dist:
            continue
        for next, w in graph[now]:
            if visit[next] > visit[now] + w:
                visit[next] = visit[now] + w
                heappush(pq, (visit[next], next))

V, E = map(int, input().split())
K = int(input())
graph = [[] for _ in range(V+1)]
visit = [10*V] * (V+1)
for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append([v, w])

bfs(K)

for i in range(1, V+1):
    if visit[i] == 10*V:
        print('INF')
    else:
        print(visit[i])