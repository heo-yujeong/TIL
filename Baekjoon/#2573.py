import sys
from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        visit[x][y] = 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if iceland[nx][ny] > 0 and not visit[nx][ny]:
                    visit[nx][ny] = 1
                    queue.append((nx, ny))
                elif iceland[nx][ny] == 0:
                    count[x][y] += 1
    return 1


N, M = map(int, sys.stdin.readline().split())
iceland = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

time = 0

while True:
    visit = [[0] * M for _ in range(N)]
    count = [[0] * M for _ in range(N)]
    result = []
    for i in range(N):
        for j in range(M):
            if iceland[i][j] > 0 and not visit[i][j]:
                result.append(bfs(i, j))

    for i in range(N):
        for j in range(M):
            iceland[i][j] -= count[i][j]
            if iceland[i][j] < 0:
                iceland[i][j] = 0

    if len(result) == 0:
        time = 0
        break
    if len(result) >= 2:
        break
    time += 1

print(time)