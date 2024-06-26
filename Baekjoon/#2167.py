import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

d = [[0] * (M+1) for _ in range(N+1)]
for i in range(1, N+1):
    for j in range(1, M+1):
        d[i][j] = arr[i-1][j-1] + d[i][j-1] + d[i-1][j] - d[i-1][j-1]

K = int(input())
for _ in range(K):
    i, j, x, y = map(int, input().split())
    print(d[x][y] - d[x][j-1] - d[i-1][y] + d[i-1][j-1])