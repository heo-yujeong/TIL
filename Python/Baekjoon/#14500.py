import sys

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(y, x, hap, cnt):
    global max_hap
    if cnt == 4:
        max_hap = max(max_hap, hap)
        return
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and not visit[nx][ny]:
            visit[nx][ny] = 1
            dfs(ny, nx, hap+paper[nx][ny], cnt+1)
            visit[nx][ny] = 0

def tdfs(y, x):
    global max_hap
    hap_lst = []
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M:
            hap_lst.append(paper[nx][ny])
    if len(hap_lst) == 4:
        hap_lst.sort(reverse=True)
        hap_lst.pop()
        max_hap = max(max_hap, sum(hap_lst)+paper[x][y])
    elif len(hap_lst) == 3:
        max_hap = max(max_hap, sum(hap_lst)+paper[x][y])
    return

N, M = map(int, sys.stdin.readline().split())
paper = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
visit = [[0] * M for _ in range(N)]

max_hap = 0
for i in range(N):
    for j in range(M):
        visit[i][j] = 1
        dfs(j, i, paper[i][j], 1)
        tdfs(j, i)
        visit[i][j] = 0

print(max_hap)