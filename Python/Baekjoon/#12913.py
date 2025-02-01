import sys
from heapq import heappush, heappop
input = sys.stdin.readline

N, K = map(int, input().split())
city = [list(map(int, list(input().strip()))) for _ in range(N)]

time = [[float('inf')] * (K+1) for _ in range(N)]
time[0][0] = 0

pq = []
heappush(pq, (0, 0, 0))

while pq:
    t, now, k = heappop(pq)

    if t > time[now][k]:
        continue

    for next in range(N):
        if next == now:
            continue

        if t + city[now][next] < time[next][k]:
            time[next][k] = t + city[now][next]
            heappush(pq, (t + city[now][next], next, k))

        if k < K:
            if t + city[now][next] / 2 < time[next][k+1]:
                time[next][k+1] = t + city[now][next] / 2
                heappush(pq, (t + city[now][next] / 2, next, k+1))

print(min(time[1]))