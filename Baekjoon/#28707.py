import sys
from heapq import heappush, heappop
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
M = int(input())
oper = []

for _ in range(M):
    l, r, c = map(int, input().split())
    oper.append((l-1, r-1, c))

pq = []
dist = {}

heappush(pq, (0, tuple(A)))
dist[tuple(A)] = 0

while pq:
    cost, current = heappop(pq)

    if dist[current] < cost:
        continue

    for l, r, c in oper:
        next = list(current)
        next[l], next[r] = next[r], next[l]
        next = tuple(next)

        plus_cost = cost + c

        if next not in dist or plus_cost < dist[next]:
            dist[next] = plus_cost
            heappush(pq, (plus_cost, next))

result = tuple(sorted(A))
print(dist[result] if result in dist else -1)