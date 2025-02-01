import sys
from heapq import heappop, heappush
input = sys.stdin.readline

def bfs(start):
    pq = []
    heappush(pq, (0, start))
    dist[start] = 0

    while pq:
        d, now = heappop(pq)
        if dist[now] < d:
            continue
        for next, nd in connect[now]:
            if dist[next] > d + nd:
                dist[next] = d + nd
                near[next] = now
                heappush(pq, (dist[next], next))

n = int(input())
m = int(input())
connect = [[] for _ in range(n+1)]

for _ in range(m):
    start, end, fee = map(int, input().split())
    connect[start].append((end, fee))

start, end = map(int, input().split())

near = [0] * (n+1)
dist = [1001*n*n] * (n+1)

bfs(start)

result = [end]
now = end
while now != start:
    now = near[now]
    result.append(now)

result.reverse()

print(dist[end])
print(len(result))
print(*result)