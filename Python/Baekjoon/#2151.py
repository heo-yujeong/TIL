import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(start_y, start_x, end_y, end_x):
    queue = deque()
    min_mirrors = float('inf')
    for d in range(4):
        queue.append((start_y, start_x, d, 0))
        visit[start_y][start_x][d] = 0

    while queue:
        y, x, d, cnt = queue.popleft()

        if y == end_y and x == end_x:
            min_mirrors = min(min_mirrors, cnt)
            continue

        ny, nx = y + dy[d], x + dx[d]

        if 0 <= nx < N and 0 <= ny < N and house[ny][nx] != '*':
            if visit[ny][nx][d] == -1 or visit[ny][nx][d] > cnt:
                queue.append((ny, nx, d, cnt))
                visit[ny][nx][d] = cnt

            if house[ny][nx] == '!':
                for nd in ((d + 1) % 4, (d + 3) % 4):
                    if visit[ny][nx][nd] == -1 or visit[ny][nx][nd] > cnt + 1:
                        queue.append((ny, nx, nd, cnt + 1))
                        visit[ny][nx][nd] = cnt + 1

    return min_mirrors

N = int(input())
house = [list(input().strip()) for _ in range(N)]
visit = [[[-1] * 4 for _ in range(N)] for _ in range(N)]

start_x = start_y = end_x = end_y = -1
for i in range(N):
    for j in range(N):
        if house[i][j] == '#':
            if start_x == -1:
                start_y, start_x = i, j
            else:
                end_y, end_x = i, j

print(bfs(start_y, start_x, end_y, end_x))