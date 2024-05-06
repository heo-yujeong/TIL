import sys
input = sys.stdin.readline

cx = [0, -1, -1, 0, 1, 1, 1, 0, -1]
cy = [0, 0, -1, -1, -1, 0, 1, 1, 1]

dx = [-1, -1 ,1, 1]
dy = [-1, 1, -1, 1]

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
cloud = [(N - 1, 0), (N - 1, 1), (N - 2, 0), (N - 2, 1)]

for _ in range(M):
    d, s = map(int, input().split())
    move_cloud = []
    for y, x in cloud:
        nx = (x + cx[d] * s) % N
        ny = (y + cy[d] * s) % N
        board[ny][nx] += 1
        move_cloud.append((ny, nx))

    for y, x in move_cloud:
        cnt = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and board[ny][nx]:
                cnt += 1
        board[y][x] += cnt

    new_cloud = []
    for i in range(N):
        for j in range(N):
            if board[i][j] >= 2 and (i, j) not in move_cloud:
                board[i][j] -= 2
                new_cloud.append((i, j))

    cloud = new_cloud

hap = 0
for b in board:
    hap += sum(b)

print(hap)