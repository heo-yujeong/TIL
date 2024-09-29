M, N = map(int, input().split())
visit = [[0] * M for _ in range(N)]

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

x, y = 0, 0
d = 0
cnt = 0

for _ in range(M*N-1):
    visit[y][x] = 1

    nx, ny = x + dx[d], y + dy[d]
    if 0 <= nx < M and 0 <= ny < N and not visit[ny][nx]:
        x, y = nx, ny
    else:
        d = (d + 1) % 4
        x, y = x + dx[d], y + dy[d]
        cnt += 1

print(cnt)