dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    queue = []
    queue.append((x, y))

    while queue:
        x, y = queue.pop(0)
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == 0:
                if graph[nx][ny] == 0:
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append((nx, ny))
                elif graph[nx][ny] == 3:
                    return visited[x][y]
    return 0


T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    graph = [list(map(int, input())) for _ in range(N)]
    visited = [[0]*N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            if graph[i][j] == 2:
                start_x, start_y = i, j

    result = bfs(start_x, start_y)

    print(f'#{test_case} {result}')