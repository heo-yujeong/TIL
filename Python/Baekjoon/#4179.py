import sys
from collections import deque
input = sys.stdin.readline

R, C = map(int, input().split())
space = [list(input().rstrip()) for _ in range(R)]
queue = deque()

for i in range(R):
    for j in range(C):
        if space[i][j] == 'J':
            queue.append((0, i, j))

for i in range(R):
    for j in range(C):
        if space[i][j] == 'F':
            queue.append((-1, i, j))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
result = 'IMPOSSIBLE'

while queue:
    time, y, x = queue.popleft()

    if time > -1 and space[y][x] != 'F' and (x == 0 or y == 0 or x == C-1 or y == R-1):
        result = time + 1
        break

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < C and 0 <= ny < R and space[ny][nx] != '#':
            if time > -1 and space[ny][nx] == '.':
                space[ny][nx] = '_'
                queue.append((time+1, ny, nx))
            elif time == -1 and space[ny][nx] != 'F':
                space[ny][nx] = 'F'
                queue.append((-1, ny, nx))

print(result)