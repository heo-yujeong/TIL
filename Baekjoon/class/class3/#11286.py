import sys
from heapq import heappush, heappop

N = int(sys.stdin.readline())
pq = []

for _ in range(N):
    num = int(sys.stdin.readline())
    if num:
        heappush(pq, (abs(num), num))
    else:
        if pq:
            print(heappop(pq)[1])
        else:
            print(0)