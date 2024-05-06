import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x, h):
    queue = deque()
    queue.append((y, x))
    visit[y][x] = 1

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and area[ny][nx] > h and not visit[ny][nx]:
                visit[ny][nx] = 1
                queue.append((ny, nx))

N = int(input())
area = []
max_h = 0

for _ in range(N):
    line = list(map(int, input().split()))
    area.append(line)
    for l in line:
        if l > max_h:
            max_h = l

max_cnt = 0
for h in range(max_h):
    visit = [[0] * N for _ in range(N)]
    cnt = 0

    for i in range(N):
        for j in range(N):
            if area[i][j] > h and not visit[i][j]:
                bfs(i, j, h)
                cnt += 1

    max_cnt = max(max_cnt, cnt)

print(max_cnt)