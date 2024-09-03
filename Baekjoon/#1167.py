import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def dfs(node, dist):
    global max_dist, max_node
    if dist > max_dist:
        max_dist, max_node = dist, node

    for next, d in graph[node]:
        if not visit[next]:
            visit[next] = 1
            dfs(next, dist+d)

V = int(input())
graph = [[] for _ in range(V+1)]
for _ in range(V):
    node, *edges = map(int, input().split())
    edges.pop()
    for i in range(len(edges)//2):
        graph[node].append([edges[2*i], edges[2*i+1]])

max_dist, max_node = 0, 1
visit = [0] * (V+1)
visit[1] =  1
dfs(1, 0)

visit = [0] * (V+1)
visit[max_node] = 1
dfs(max_node, 0)

print(max_dist)