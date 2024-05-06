def dfs(s):
    global result
    visited[s] = 1

    for next in range(V+1):
        if visited[next] == 0 and graph[s][next] == 1:
            result += 1
            dfs(next)

V = int(input())
E = int(input())

graph = [[0] * (V+1) for _ in range(V+1)]
visited = [0] * (V+1)

for i in range(E):
    s, e = map(int, input().split())
    graph[s][e] = 1
    graph[e][s] = 1

result = 0
dfs(1)

print(result)