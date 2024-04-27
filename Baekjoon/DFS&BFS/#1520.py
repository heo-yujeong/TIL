import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(y, x):
    if y == M-1 and x == N-1:
        return 1

    if dp[y][x] != -1:
        return dp[y][x]

    dp[y][x] = 0
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and place[ny][nx] < place[y][x]:
            dp[y][x] += dfs(ny, nx)

    return dp[y][x]

M, N = map(int, input().split())
place = [list(map(int, input().split())) for _ in range(M)]

dp = [[-1] * N for _ in range(M)]
print(dfs(0, 0))
