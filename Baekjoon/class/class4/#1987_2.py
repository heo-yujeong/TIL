import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(y, x, cnt):
    global max_cnt
    max_cnt = max(max_cnt, cnt)

    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]
        if 0 <= nx < C and 0 <= ny < R and not visit[ord(board[ny][nx])-65]:
            visit[ord(board[ny][nx])-65] = 1
            dfs(ny, nx, cnt+1)
            visit[ord(board[ny][nx])-65] = 0

R, C = map(int, input().split())
board = [list(input()) for _ in range(R)]
visit = [0] * 26

max_cnt = 0
visit[ord(board[0][0])-65] = 1
dfs(0, 0, 1)

print(max_cnt)