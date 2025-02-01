import sys
from heapq import heappush, heappop
input = sys.stdin.readline

N, K = map(int, input().split())
jewel = []
bags = []

for _ in range(N):
    M, V = map(int, input().split())
    jewel.append((M, V))

for _ in range(K):
    C = int(input())
    bags.append(C)

jewel.sort()
bags.sort()

max_price = 0
available = []
idx = 0

for bag in bags:
    while idx < N and jewel[idx][0] <= bag:
        heappush(available, -jewel[idx][1])
        idx += 1
    
    if available:
        max_price -= heappop(available)

print(max_price)