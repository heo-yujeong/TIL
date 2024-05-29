import sys
from collections import deque

input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x):
    queue = deque()
    queue.append([y, x, 0, 1, 1])
    visit[y][x][0] = 1

    while queue:
        y, x, cnt, time, moves = queue.popleft()
        if y == N-1 and x == M-1:
            return moves
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < M and 0 <= ny < N:
                if not place[ny][nx] and not visit[ny][nx][cnt]:
                    # 낮인 경우
                    if time == 1:
                        visit[ny][nx][cnt] = 1
                        queue.append([ny, nx, cnt, 0, moves+1])
                    # 밤인 경우
                    else:
                        visit[ny][nx][cnt] = 1
                        queue.append([ny, nx, cnt, 1, moves+1])
                elif place[ny][nx] and cnt < K and not visit[ny][nx][cnt+1]:
                    # 낮인 경우
                    if time == 1:
                        visit[ny][nx][cnt+1] = 1
                        queue.append([ny, nx, cnt+1, 0, moves+1])
                    # 밤인 경우
                    else:
                        queue.append([y, x, cnt, 1, moves+1])
    return -1

N, M, K = map(int, input().split())
place = [list(map(int, list(input().strip()))) for _ in range(N)]
visit = [[[0] * (K+1) for _ in range(M)] for _ in range(N)]
print(bfs(0, 0))