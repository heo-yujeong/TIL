import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    queue = deque()
    queue.append((0, 0, 0))
    visit[0][0][0] = 1

    while queue:
        y, x, broken = queue.popleft()

        if x == M-1 and y == N-1:
            return visit[y][x][broken]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < M and 0 <= ny < N:
                if array[ny][nx] and broken == 0:
                    visit[ny][nx][1] = visit[y][x][0] + 1
                    queue.append((ny, nx, 1))
                if not array[ny][nx] and not visit[ny][nx][broken]:
                    visit[ny][nx][broken] = visit[y][x][broken] + 1
                    queue.append((ny, nx, broken))
    return -1


N, M = map(int, input().split())
array = [list(map(int, list(input().rstrip()))) for _ in range(N)]
visit = [[[0, 0] for _ in range(M)] for _ in range(N)]

print(bfs())