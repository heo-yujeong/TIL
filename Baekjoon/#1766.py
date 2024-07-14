import sys
from heapq import heappush, heappop
input = sys.stdin.readline

N, M = map(int, input().split())
problem = [[] for _ in range(N+1)]
in_degree = [0] * (N+1)
order = []

for _ in range(M):
    pre, after = map(int, input().split())
    problem[pre].append(after)
    in_degree[after] += 1

pq = []
for i in range(1, N+1):
    if in_degree[i] == 0:
        heappush(pq, i)

while pq:
    now = heappop(pq)
    order.append(now)

    for next in problem[now]:
        in_degree[next] -= 1
        if in_degree[next] == 0:
            heappush(pq, next)

print(*order)