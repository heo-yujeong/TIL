import sys
from heapq import heappush, heappop
input = sys.stdin.readline

N, M = map(int, input().split())
saw = list(map(int, input().split()))
back_door = [[] for _ in range(N)]
times = [float('inf')] * N

for _ in range(M):
    a, b, t = map(int, input().split())
    back_door[a].append((t, b))
    back_door[b].append((t, a))

pq = [(0, 0)]
times[0] = 0

while pq:
    time, now = heappop(pq)

    if times[now] < time:
        continue

    for t, next in back_door[now]:
        if saw[next] and next != N-1:
            continue
        if times[next] > times[now] + t:
            times[next] = times[now] + t
            heappush(pq, (times[now] + t, next))

if times[N-1] == float('inf'):
    print(-1)
else:
    print(times[N-1])