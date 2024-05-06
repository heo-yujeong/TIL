import sys
from collections import deque

dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

def bfs(lst):
    while lst:
        h, y, x = lst.popleft()
        for i in range(6):
            nh = h + dz[i]
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nh < H and 0 <= nx < M and 0 <= ny < N and not visit[nh][ny][nx] and tomato[nh][ny][nx] != -1:
                visit[nh][ny][nx] = visit[h][y][x] + 1
                lst.append((nh, ny, nx))


M, N, H = map(int, sys.stdin.readline().split())
tomato = [[list(map(int, sys.stdin.readline().split())) for _ in range(N)] for _ in range(H)]
visit = [[[0] * M for _ in range(N)] for _ in range(H)]

status = 0
blank = 0
start = deque()

for h in range(H):
    for i in range(N):
        for j in range(M):
            if tomato[h][i][j] == -1:
                blank += 1
            if tomato[h][i][j] == 1:
                status += 1
                visit[h][i][j] = 1
                start.append((h, i, j))

if status+blank == H*N*M:
    print(0)
else:
    bfs(start)

    status = 0
    max_day = 0
    for h in range(H):
        for i in range(N):
            for j in range(M):
                if visit[h][i][j]:
                    status += 1
                max_day = max(max_day, visit[h][i][j] - 1)

    if status + blank == H*N*M:
        print(max_day)
    else:
        print(-1)