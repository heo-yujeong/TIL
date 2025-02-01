import sys
input = sys.stdin.readline

def dfs(y, x):
    global result

    visit[y][x] = 1
    cycle.append([y, x])

    if maps[y][x] == 'U' and y > 0:
        y -= 1
    elif maps[y][x] == 'D' and y < N-1:
        y += 1
    elif maps[y][x] == 'L' and x > 0:
        x -= 1
    elif maps[y][x] == 'R' and x < M-1:
        x += 1

    if visit[y][x]:
        if [y, x] in cycle:
            result += 1
    else:
        dfs(y, x)

N, M = map(int, input().split())
maps = [list(input()) for _ in range(N)]
visit = [[0] * M for _ in range(N)]

result = 0

for i in range(N):
    for j in range(M):
        if not visit[i][j]:
            cycle = []
            dfs(i, j)

print(result)