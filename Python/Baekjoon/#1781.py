import sys
from heapq import heappush, heappop
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
arr.sort()

pq = []
for a in arr:
    heappush(pq, a[1])
    if a[0] < len(pq):
        heappop(pq)

print(sum(pq))