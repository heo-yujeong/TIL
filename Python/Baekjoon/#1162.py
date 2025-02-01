import sys
from heapq import heappush, heappop
input = sys.stdin.readline

N, M, K = map(int, input().split())
load = [[] for _ in range(N)]
for _ in range(M):
    a, b, time = map(int, input().split())
    load[a-1].append((b-1, time))
    load[b-1].append((a-1, time))

taken_times = [[float('inf')] * (K+1) for _ in range(N)]

pq = []
heappush(pq, (0, 0, 0))
taken_times[0][0] = 0

while pq:
    ttime, now, k = heappop(pq)
    
    if ttime > taken_times[now][k]:
        continue

    for next, time in load[now]:
        if ttime + time < taken_times[next][k]:
            taken_times[next][k] = ttime + time
            heappush(pq, (ttime+time, next, k))
        
        if k < K:
            if ttime < taken_times[next][k+1]:
                taken_times[next][k+1] = ttime
                heappush(pq, (ttime, next, k+1))

print(min(taken_times[N-1]))