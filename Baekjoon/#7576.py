import sys
from collections import deque
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(lst):
    while lst:
        y, x = lst.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < M and 0 <= ny < N and not visit[ny][nx] and tomato[ny][nx] != -1:
                visit[ny][nx] = visit[y][x] + 1
                lst.append((ny, nx))

M, N = map(int, sys.stdin.readline().split())
tomato = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
visit = [[0] * M for _ in range(N)]

status = 0
blank = 0
start = deque()
for i in range(N):
    for j in range(M):
        if tomato[i][j] == -1:
            blank += 1
        elif tomato[i][j] == 1:
            status += 1
            visit[i][j] = 1
            start.append((i, j))

if status+blank == M*N:
    print(0)

else:
    bfs(start)

    status = 0
    max_day = 0
    for i in range(N):
        for j in range(M):
            if visit[i][j]:
                status += 1
            max_day = max(max_day, visit[i][j]-1)

    if status+blank == N*M:
        print(max_day)
    else:
        print(-1)