from collections import deque
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x):
    queue = deque()
    queue.append((y, x))

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n and not visit[ny][nx] and map[ny][nx] == 1:
                queue.append((ny, nx))
                visit[ny][nx] = visit[y][x] + 1


n, m = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(n)]
visit = [[0]*m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if map[i][j] == 2:
            start_y, start_x = i, j

bfs(start_y, start_x)

for i in range(n):
    for j in range(m):
        if map[i][j] == 1 and not visit[i][j]:
            print(-1, end=' ')
        else:
            print(visit[i][j], end=' ')
    print()