import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x):
    global cnt
    queue = deque()
    queue.append((y, x))

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < M and 0 <= ny < N and campus[ny][nx] in 'OP':
                queue.append((ny, nx))
                if campus[ny][nx] == 'P':
                    cnt += 1
                campus[ny][nx] = 'X'


N, M = map(int, sys.stdin.readline().split())
campus = [list(sys.stdin.readline()) for _ in range(N)]

cnt = 0
for i in range(N):
    for j in range(M):
        if campus[i][j] == 'I':
            bfs(i, j)

if cnt == 0:
    print('TT')
else:
    print(cnt)