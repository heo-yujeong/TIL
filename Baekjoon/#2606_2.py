import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

def dfs(s):
    global result
    visited[s] = 1

    for next in graph[s]:
        if not visited[next]:
            result += 1
            dfs(next)

V = int(input())
E = int(input())

graph = [[] for _ in range(V+1)]
visited = [0] * (V+1)

for i in range(E):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

result = 0
dfs(1)

print(result)