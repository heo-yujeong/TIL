import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(now, wei):
    for next, w in graph[now]:
        if dist[next] == -1:
            dist[next] = wei + w
            dfs(next, wei+w)

n = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    p, c, w = map(int, input().split())
    graph[p].append([c, w])
    graph[c].append([p, w])

dist = [-1] * (n+1)
dist[1] = 0
dfs(1, 0)

start = dist.index(max(dist))
dist = [-1] * (n+1)
dist[start] = 0
dfs(start, 0)

print(max(dist))