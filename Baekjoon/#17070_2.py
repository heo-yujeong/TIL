import sys
input = sys.stdin.readline

N = int(input())
house = [list(map(int, input().split())) for i in range(N)]

d = [[[0 for _ in range(N)] for _ in range(N)] for _ in range(3)]
d[0][0][1] = 1

for i in range(2, N):
    if house[0][i] == 0:
        d[0][0][i] = d[0][0][i-1]

for i in range(1, N):
    for j in range(2, N):
        if house[i][j] == house[i-1][j] == house[i][j-1] == 0:
            d[2][i][j] = d[0][i-1][j-1] + d[1][i-1][j-1] + d[2][i-1][j-1]
        if house[i][j] == 0:
            d[0][i][j] = d[0][i][j-1] + d[2][i][j-1]
            d[1][i][j] = d[1][i-1][j] + d[2][i-1][j]

print(d[0][N-1][N-1] + d[1][N-1][N-1] + d[2][N-1][N-1])