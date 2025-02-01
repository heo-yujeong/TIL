def dfs(y, x):
    visit[y][x] = 1
    if floor[y][x] == '-':
        if x+1 < M and floor[y][x+1] == '-' and not visit[y][x+1]:
            dfs(y, x+1)
    if floor[y][x] == '|':
        if y+1 < N and floor[y+1][x] == '|' and not visit[y+1][x]:
            dfs(y+1, x)

N, M = map(int, input().split())
floor = [list(input()) for _ in range(N)]
visit = [[0] * M for _ in range(N)]

cnt = 0

for i in range(N):
    for j in range(M):
        if not visit[i][j]:
            dfs(i, j)
            cnt += 1

print(cnt)