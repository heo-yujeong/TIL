import sys
import copy
from itertools import combinations
from collections import deque

input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    global max_cnt
    queue = deque()
    for i, j in virus:
        queue.append([i, j])

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            ny, nx = y+dy[i], x+dx[i]
            if 0 <= nx < M and 0 <= ny < N and not cp_labor[ny][nx]:
                cp_labor[ny][nx] = 2
                queue.append([ny, nx])

    cnt = 0
    for row in cp_labor:
        cnt += row.count(0)
    max_cnt = max(max_cnt, cnt)


N, M = map(int, input().split())
labor = [list(map(int, input().split())) for _ in range(N)]
virus = []
non_virus = []

for i in range(N):
    for j in range(M):
        if labor[i][j] == 2:
            virus.append([i, j])
        if labor[i][j] == 0:
            non_virus.append([i, j])

max_cnt = 0
for select_wall in combinations(non_virus, 3):
    cp_labor = copy.deepcopy(labor)
    for i, j in select_wall:
        cp_labor[i][j] = 1
    bfs()

print(max_cnt)