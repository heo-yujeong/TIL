import sys
from collections import deque

input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x):
    queue = deque()
    queue.append([y, x, 0])
    visit[y][x][0] = 1

    while queue:
        y, x, cnt = queue.popleft()
        if [y, x] == [N - 1, M - 1]:
            return visit[y][x][cnt]
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < M and 0 <= ny < N:
                if not place[ny][nx] and not visit[ny][nx][cnt]:
                    visit[ny][nx][cnt] = visit[y][x][cnt] + 1
                    queue.append([ny, nx, cnt])
                elif place[ny][nx] and cnt < K and not visit[ny][nx][cnt+1]:
                    visit[ny][nx][cnt+1] = visit[y][x][cnt] + 1
                    queue.append([ny, nx, cnt+1])
    return -1

N, M, K = map(int, input().split())
place = [list(map(int, list(input().strip()))) for _ in range(N)]
visit = [[[0] * (K+1) for _ in range(M)] for _ in range(N)]
print(bfs(0, 0))