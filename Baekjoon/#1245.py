import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, -1, 1]

N, M = map(int, input().split())
farm = [list(map(int, input().split())) for _ in range(N)]
visit = [[0] * M for _ in range(N)]
cnt = 0

for i in range(N):
    for j in range(M):
        if visit[i][j]:
            continue

        queue = deque()
        queue.append((i, j))
        flag = True

        while queue:
            y, x = queue.popleft()
            visit[y][x] = 1

            for dir in range(8):
                nx, ny = x + dx[dir], y + dy[dir]
                if 0 <= nx < M and 0 <= ny < N:
                    if farm[y][x] == farm[ny][nx] and not visit[ny][nx]:
                        queue.append((ny, nx))
                    elif farm[y][x] < farm[ny][nx]:
                        flag = False
        if flag:
            cnt += 1

print(cnt)