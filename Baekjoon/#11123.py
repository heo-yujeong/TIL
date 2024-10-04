import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x):
    queue = deque()
    queue.append((y, x))
    visit[y][x] = 1

    while queue:
        y, x = queue.popleft()
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < W and 0 <= ny < H and space[ny][nx] == '#' and not visit[ny][nx]:
                queue.append((ny, nx))
                visit[ny][nx] = 1

T = int(input())

for _ in range(T):
    H, W = map(int, input().split())
    space = [input().strip() for _ in range(H)]
    visit = [[0] * W for _ in range(H)]

    cnt = 0

    for i in range(H):
        for j in range(W):
            if space[i][j] == '#' and not visit[i][j]:
                bfs(i, j)
                cnt += 1

    print(cnt)