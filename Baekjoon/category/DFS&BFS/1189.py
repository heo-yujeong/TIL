import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def backtrack(y, x, step):
    global cnt
    if y == 0 and x == (C-1) and step == K:
        cnt += 1
        return
    if step >= K:
        return
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < C and 0 <= ny < R and place[ny][nx] != 'T':
            if not visit[ny][nx]:
                visit[ny][nx] = 1
                backtrack(ny, nx, step+1)
                visit[ny][nx] = 0

R, C, K = map(int, input().split())
place = [list(input()) for _ in range(R)]
visit = [[0] * C for _ in range(R)]

cnt = 0

visit[R-1][0] = 1
backtrack(R-1, 0, 1)

print(cnt)