import sys
from heapq import heappush, heappop
input = sys.stdin.readline

N = int(input())
planet = [list(map(int, input().split())) + [i] for i in range(N)]

edges = []
for i in range(3):
    planet.sort(key=lambda x: x[i])
    for j in range(1, N):
        cost = abs(planet[j][i] - planet[j-1][i])
        heappush(edges, (cost, planet[j][3], planet[j-1][3]))

parent = list(range(N))

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    rootX = find(x)
    rootY = find(y)
    if rootX != rootY:
        parent[rootY] = rootX

min_fee = 0
edge_count = 0

while edges and edge_count < N - 1:
    cost, u, v = heappop(edges)
    if find(u) != find(v):
        union(u, v)
        min_fee += cost
        edge_count += 1

print(min_fee)