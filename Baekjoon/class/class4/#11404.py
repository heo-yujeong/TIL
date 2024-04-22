import sys
from heapq import heappush, heappop
input = sys.stdin.readline

def bfs(start):
    pq = []
    heappush(pq, (0, start))
    cost[start] = 0

    while pq:
        now_cost, now = heappop(pq)
        if cost[now] < now_cost:
            continue
        for next, c in graph[now]:
            if now_cost + c < cost[next]:
                cost[next] = now_cost + c
                heappush(pq, (now_cost+c, next))

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

for i in range(1, n+1):
    cost = [100000*n] * (n+1)
    bfs(i)
    for i in range(1, n+1):
        if cost[i] == 100000*n:
            print(0, end=' ')
        else:
            print(cost[i], end=' ')
    print()