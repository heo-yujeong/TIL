import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0, -1, 1, -1, 1]
dy = [0, 0, -1, 1, -1, -1, 1, 1]

def bfs(y, x):
    queue = deque()
    queue.append([y, x])

    while queue:
        y, x = queue.popleft()
        for i in range(8):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < w and 0 <= ny < h and place[ny][nx] and not visit[ny][nx]:
                visit[ny][nx] = 1
                queue.append([ny, nx])

while True:
    w, h = map(int, input().split())
    if w == h == 0:
        break
    place = [list(map(int, input().split())) for _ in range(h)]
    visit = [[0] * w for _ in range(h)]

    rand = 0
    for i in range(h):
        for j in range(w):
            if place[i][j] and not visit[i][j]:
                visit[i][j] = 1
                bfs(i, j)
                rand += 1
    print(rand)