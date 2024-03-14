from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x):
    queue = deque()
    queue.append((y, x))
    visit[y][x] = 1

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visit[ny][nx] and colors[ny][nx]==colors[y][x]:
                queue.append((ny, nx))
                visit[ny][nx] = 1

def bfs_blind(y, x, color):
    queue = deque()
    queue.append((y, x))
    visit[y][x] = 1

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visit[ny][nx]:
                if color != 'B' and colors[ny][nx] != 'B':
                    queue.append((ny, nx))
                    visit[ny][nx] = 1
                if color == 'B' and colors[ny][nx] == 'B':
                    queue.append((ny, nx))
                    visit[ny][nx] = 1


N = int(input())
colors = [list(input()) for _ in range(N)]

visit = [[0]*N for _ in range(N)]
cnt = 0
for i in range(N):
    for j in range(N):
        if not visit[i][j]:
            bfs(i, j)
            cnt += 1

visit = [[0]*N for _ in range(N)]
cnt_blind = 0
for i in range(N):
    for j in range(N):
        if not visit[i][j]:
            bfs_blind(i, j, colors[i][j])
            cnt_blind += 1

print(cnt, cnt_blind)