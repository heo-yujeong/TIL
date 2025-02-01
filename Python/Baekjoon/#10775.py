import sys
input = sys.stdin.readline

def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x, y = find(x), find(y)
    if x < y:
        parent[y] = x
    else:
        parent[x] = y

G = int(input())
P = int(input())
airplane = [int(input()) for _ in range(P)]
parent = [i for i in range(G+1)]

cnt = 0

for plane in airplane:
    p = find(plane)
    if p == 0:
        break
    union(p, p-1)
    cnt += 1

print(cnt)