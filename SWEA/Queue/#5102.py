from collections import deque

def bfs(start, end):
    queue = deque()
    queue.append(start)
    visited[start] = 1

    while queue:
        start = queue.popleft()
        for next in range(1, V+1):
            if visited[next] == 0 and graph[start][next] == 1:
                visited[next] = visited[start] + 1
                queue.append(next)
                if next == end:
                    return visited[start]
    return 0


T = int(input())

for test_case in range(1, T+1):
    V, E = map(int, input().split())
    graph = [[0] * (V+1) for _ in range(V+1)]
    visited = [0] * (V+1)

    for i in range(E):
        s, g = map(int, input().split())
        graph[s][g] = 1
        graph[g][s] = 1

    S, G = map(int, input().split())

    result = bfs(S, G)

    print(f'#{test_case} {result}')