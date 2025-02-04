import sys
from heapq import heappush, heappop
input = sys.stdin.readline

def dijkstra():
    pq = []
    for n in city_num:
        heappush(pq, (0, n))
        dist[n] = 0

    while pq:
        cost, num = heappop(pq)
        if dist[num] < cost:
            continue

        for next_num, next_cost in graph[num]:
            if cost + next_cost < dist[next_num]:
                dist[next_num] = cost + next_cost
                heappush(pq, (dist[next_num], next_num))


N, M, K = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    U, V, C = map(int, input().split())
    graph[V].append([U, C])
city_num = list(map(int, input().split()))

max_num, max_cost = 0, 0
dist = [N * 100000] * (N+1)
dijkstra()

for i, c in enumerate(dist):
    if c > max_cost and c != N*100000:
        max_num, max_cost = i, c

print(max_num)
print(max_cost)