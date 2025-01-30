import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(Rx, Ry, Bx, By):
    queue = deque()
    queue.append((Rx, Ry, Bx, By))
    visit = []
    visit.append((Rx, Ry, Bx, By))
    cnt = 0

    while queue:
        for _ in range(len(queue)):
            Rx, Ry, Bx, By = queue.popleft()

            if cnt > 10:
                print(-1)
                return
            if board[Ry][Rx] == 'O':
                print(cnt)
                return
            for i in range(4):
                nRx, nRy = Rx, Ry
                while True:
                    nRx += dx[i]
                    nRy += dy[i]
                    if board[nRy][nRx] == '#':
                        nRx -= dx[i]
                        nRy -= dy[i]
                        break
                    if board[nRy][nRx] == 'O':
                        break

                nBx, nBy = Bx, By
                while True:
                    nBx += dx[i]
                    nBy += dy[i]
                    if board[nBy][nBx] == '#':
                        nBx -= dx[i]
                        nBy -= dy[i]
                        break
                    if board[nBy][nBx] == 'O':
                        break

                if board[nBy][nBx] == 'O':
                    continue

                if nRx == nBx and nRy == nBy:
                    if abs(nRx-Rx) + abs(nRy-Ry) > abs(nBx-Bx) + abs(nBy-By):
                        nRx -= dx[i]
                        nRy -= dy[i]
                    else:
                        nBx -= dx[i]
                        nBy -= dy[i]

                if (nRx, nRy, nBx, nBy) not in visit:
                    queue.append((nRx, nRy, nBx, nBy))
                    visit.append((nRx, nRy, nBx, nBy))
        cnt += 1
    print(-1)


N, M = map(int, input().split())
board = []
Rx, Ry, Bx, By = 0, 0, 0, 0

for i in range(N):
    line = input()
    board.append(line)
    for j in range(M):
        if line[j] == 'R':
            Rx, Ry = j, i
        if line[j] == 'B':
            Bx, By = j, i

bfs(Rx, Ry, Bx, By)