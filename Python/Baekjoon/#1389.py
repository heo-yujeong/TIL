N, M = map(int, input().split())
graph = [[N]*N for _ in range(N)]

for _ in range(M):
    one, other = map(int, input().split())
    graph[one-1][other-1] = 1
    graph[other-1][one-1] = 1

for i in range(N):
    graph[i][i] = 0

for k in range(N):
    for i in range(N):
        for j in range(N):
            if i == j:
                continue
            else:
                if graph[i][k] and graph[k][j]:
                    graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j])

max_con = N*N
min_usr = 0

for i in range(N-1, -1, -1):
    if max_con >= sum(graph[i]):
        max_con = sum(graph[i])
        min_usr = i
print(min_usr+1)