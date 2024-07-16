from heapq import heappush, heappop

N = int(input())
costs = [list(map(int, input().split())) for _ in range(N)]
visit = [0] * N

min_cost = 0
pq = [(0, 0)]

while pq:
    cost, now = heappop(pq)

    if visit[now]:
        continue

    visit[now] = 1
    min_cost += cost

    for next in range(N):
        if now == next:
            continue
        if not visit[next]:
            heappush(pq, (costs[now][next], next))

print(min_cost)