import sys
from heapq import heappush, heappop
input = sys.stdin.readline

def dijkstra(start):
    pq = []
    heappush(pq, (0, start))
    dist[start] = 0

    while pq:
        go_len, now = heappop(pq)
        if dist[now] < go_len:
            continue
        for next, l in graph[now]:
            if go_len + l < dist[next]:
                dist[next] = go_len+l
                heappush(pq, (go_len+l, next))

n, m, r = map(int, input().split())
num_of_item = [0] + list(map(int, input().split()))
graph = [[] for _ in range(n+1)]

for _ in range(r):
    a, b, l = map(int, input().split())
    graph[a].append([b, l])
    graph[b].append([a, l])

max_cnt = 0
for num in range(1, n+1):
    dist = [15 * n] * (n + 1)
    dijkstra(num)
    cnt = 0
    for i in range(1, n+1):
        if dist[i] <= m:
            cnt += num_of_item[i]

    max_cnt = max(max_cnt, cnt)

print(max_cnt)