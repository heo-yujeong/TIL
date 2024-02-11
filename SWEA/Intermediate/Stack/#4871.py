T = int(input())

# 방법 1
def DFS(start, end):
    stack = []
    stack.append(start)

    while stack:
        now = stack.pop()
        visited[now] = True
        for next in range(1, V+1):
            if not visited[next] and graph[now][next] == 1:
                if next == end:
                    return 1
                stack.append(next)
    return 0

for test_case in range(1, T+1):
    V, E = map(int, input().split())
    visited = [False] * (V+1)
    graph = [[0] * (V+1) for _ in range(V+1)]

    for _ in range(E):
        i, j = map(int, input().split())
        graph[i][j] = 1

    S, G = map(int, input().split())
    print(f'#{test_case} {DFS(S, G)}')


# 방법 2
# for test_case in range(1, T+1):
#     V, E = map(int, input().split())
#     graph = [[0] * (V+1) for _ in range(V+1)]

#     for i in range(E):
#         start, end = map(int, input().split())
#         graph[start][end] = 1
    
#     S, G = map(int, input().split())

#     visited = [0] * (V+1)
#     stack = []
#     stack.append(S)
#     visited[S] = 1

#     result = 0

#     while stack:
#         top = stack[-1]

#         if top == G:
#             result = 1
#             break

#         for i in range(V+1):
#             if graph[top][i] and not visited[i]:
#                 stack.append(i)
#                 visited[i] = 1
#                 break
#         else:
#             stack.pop()
    
#     print(f'#{test_case} {result}')