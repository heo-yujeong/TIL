import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x, region_id):
    queue = deque()
    queue.append((y, x))
    visit[y][x] = region_id
    cnt = 1

    while queue:
        cy, cx = queue.popleft()
        for i in range(4):
            ny, nx = cy + dy[i], cx + dx[i]
            if 0 <= nx < M and 0 <= ny < N and not place[ny][nx] and not visit[ny][nx]:
                visit[ny][nx] = region_id
                cnt += 1
                queue.append((ny, nx))
    return cnt

N, M = map(int, input().split())
place = [list(map(int, input().strip())) for _ in range(N)]
visit = [[0] * M for _ in range(N)]
region_sizes = {}
region_id = 1

for i in range(N):
    for j in range(M):
        if place[i][j] == 0 and visit[i][j] == 0:
            size = bfs(i, j, region_id)
            region_sizes[region_id] = size
            region_id += 1

result = [[0] * M for _ in range(N)]
for i in range(N):
    for j in range(M):
        if place[i][j] == 1:
            unique_regions = set()
            for k in range(4):
                ni, nj = i + dy[k], j + dx[k]
                if 0 <= ni < N and 0 <= nj < M and visit[ni][nj] > 0:
                    unique_regions.add(visit[ni][nj])
            result[i][j] = (sum(region_sizes[rid] for rid in unique_regions) + 1) % 10

for row in result:
    print("".join(map(str, row)))