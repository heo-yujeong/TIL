import sys
from collections import deque
from itertools import combinations
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(start):
    global min_time
    queue = deque()
    time = 0
    for i in range(len(start)):
        queue.append(start[i])
        visit[start[i][0]][start[i][1]] = 1

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and labor[ny][nx] != 1 and not visit[ny][nx]:
                visit[ny][nx] = visit[y][x] + 1
                time = max(time, visit[ny][nx])
                queue.append([ny, nx])

    not_spread = False
    for i in range(N):
        for j in range(N):
            if not visit[i][j] and labor[i][j] != 1:
                not_spread = True

    if not not_spread:
        min_time = min(min_time, time)

N, M = map(int, input().split())
labor = [list(map(int, input().split())) for _ in range(N)]
virus = []
for i in range(N):
    for j in range(N):
        if labor[i][j] == 2:
            virus.append([i, j])

min_time = 50 * 50
for combi in combinations(virus, M):
    visit = [[0] * N for _ in range(N)]
    bfs(combi)

if min_time == 50 * 50:
    print(-1)
else:
    if min_time == 0:
        print(0)
    else:
        print(min_time - 1)