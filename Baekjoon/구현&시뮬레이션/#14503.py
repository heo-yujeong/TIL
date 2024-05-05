import sys
input = sys.stdin.readline

N, M = map(int, input().split())
r, c, d = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(N)]

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

cnt = 0
while True:
    if not room[r][c]:
        room[r][c] = 2
        cnt += 1

    for _ in range(4):
        d = (d - 1) % 4
        nr = r + dr[d]
        nc = c + dc[d]
        if 0 <= nr < N and 0 <= nc < M and not room[nr][nc]:
            r = nr
            c = nc
            break
    else:
        nr = r - dr[d]
        nc = c - dc[d]
        if 0 <= nr < N and 0 <= nc < M:
            if room[nr][nc] == 1:
                break
            r = nr
            c = nc

print(cnt)