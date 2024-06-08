import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

time = 0

while True:
    queue = deque()
    melt = [[0]*M for _ in range(N)]
    queue.append([0, 0])
    melt[0][0] = 1

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < M and 0 <= ny < N and not melt[ny][nx]:
                if board[ny][nx]:
                    board[ny][nx] += 1
                else:
                    melt[ny][nx] = 1
                    queue.append([ny, nx])

    is_melted = False
    for i in range(N):
        for j in range(M):
            if board[i][j] >= 3:
                board[i][j] = 0
            elif board[i][j] > 0:
                is_melted = True
                board[i][j] = 1
    time += 1

    if not is_melted:
        print(time)
        break