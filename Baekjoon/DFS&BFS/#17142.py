import sys
from collections import deque
from itertools import combinations
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(com, left):
    global min_time
    queue = deque()
    for c in com:
        queue.append(c)

    time = 0
    while queue:
        if not left:
            break
        time += 1
        if time >= min_time:
            return
        for _ in range(len(queue)):
            y, x = queue.popleft()
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if 0 <= nx < N and 0 <= ny < N and not visit[ny][nx] and labor[ny][nx] != 1:
                    visit[ny][nx] = 1
                    queue.append([ny, nx])
                    if not labor[ny][nx]:
                        left -= 1

    if not left:
        min_time = min(min_time, time)

N, M = map(int, input().split())
labor = []
virus = []
cnt = 0
for i in range(N):
    line = list(map(int, input().split()))
    for j in range(len(line)):
        if line[j] == 2:
            virus.append([i, j])
        if not line[j]:
            cnt += 1
    labor.append(line)

min_time = N * N
for combi in combinations(virus, M):
    visit = [[0] * N for _ in range(N)]
    bfs(combi, cnt)

if min_time == N * N:
    print(-1)
else:
    print(min_time)