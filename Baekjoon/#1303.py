from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x, color):
    queue = deque()
    visit[y][x] = 1
    queue.append((y, x))
    cnt = 1

    while queue:
        y, x = queue.popleft()
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < N and 0 <= ny < M and not visit[ny][nx] and zone[ny][nx] == color:
                visit[ny][nx] = 1
                queue.append((ny, nx))
                cnt += 1
    return cnt

N, M = map(int, input().split())
zone = [list(input()) for _ in range(M)]
visit = [[0] * N for _ in range(M)]
W, B = 0, 0

for i in range(M):
    for j in range(N):
        if not visit[i][j]:
            power = bfs(i, j, zone[i][j])
            if zone[i][j] == 'W':
                W += (power ** 2)
            else:
                B += (power ** 2)

print(W, B)