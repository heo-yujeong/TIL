from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

N, M = map(int, input().split())
miro = [list(map(int, list(input()))) for _ in range(N)]
visit = [[0] * M for _ in range(N)]

queue = deque()
queue.append((0, 0))
visit[0][0] = 1

while queue:
    y, x = queue.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < M and 0 <= ny < N and miro[ny][nx] and not visit[ny][nx]:
            visit[ny][nx] = visit[y][x] + 1
            queue.append((ny, nx))

print(visit[N-1][M-1])