import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x):
    queue = deque()
    queue.append((y, x))
    visit[y][x] = 1
    cnt = 1

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < m and 0 <= ny < n and painting[ny][nx] and not visit[ny][nx]:
                visit[ny][nx] = 1
                cnt += 1
                queue.append((ny, nx))

    return cnt


n, m = map(int, input().split())
painting = [list(map(int, input().split())) for i in range(n)]
visit = [[0] * m for _ in range(n)]
max_extend = 0
cnt_painting = 0

for i in range(n):
    for j in range(m):
        if painting[i][j] and not visit[i][j]:
            extend = bfs(i, j)
            max_extend = max(max_extend, extend)
            cnt_painting += 1

print(cnt_painting)
print(max_extend)