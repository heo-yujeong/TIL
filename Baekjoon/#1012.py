import sys
sys.setrecursionlimit(10**6)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(y, x):
    if field[y][x] == 1:
        field[y][x] = 0

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < M and 0 <= ny < N:
                dfs(ny, nx)
        return 1
    return 0

T = int(input())

for _ in range(T):
    N, M, K = map(int, input().split())
    field = [[0] * M for _ in range(N)]

    for _ in range(K):
        X, Y = map(int, input().split())
        field[X][Y] = 1

    result = 0
    for i in range(N):
        for j in range(M):
            if dfs(i, j):
                result += 1

    print(result)