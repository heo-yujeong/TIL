import sys
input = sys.stdin.readline

def dfs(y, x, dir):
    global cnt

    if x == N-1 and y == N-1:
        cnt += 1
        return
    if y+1 < N and x+1 < N:
        if house[y+1][x+1] == house[y][x+1] == house[y+1][x] == 0:
            dfs(y+1, x+1, 2)
    if dir in [0, 2]:
        if x+1 < N and house[y][x+1] == 0:
            dfs(y, x+1, 0)
    if dir in [1, 2]:
        if y+1 < N and house[y+1][x] == 0:
            dfs(y+1, x, 1)

N = int(input())
house = [list(map(int, input().split())) for _ in range(N)]

cnt = 0

dfs(0, 1, 0)

print(cnt)