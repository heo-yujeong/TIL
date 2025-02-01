import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x):
    queue = deque()
    union = []
    queue.append([y, x])
    union.append([y, x])

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visit[ny][nx]:
                if L <= abs(population[y][x]-population[ny][nx]) <= R:
                    visit[ny][nx] = 1
                    queue.append([ny, nx])
                    union.append([ny, nx])
    return union

N, L, R = map(int, input().split())
population = [list(map(int, input().split())) for _ in range(N)]

day = 0
while True:
    stop = False
    visit = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if not visit[i][j]:
                visit[i][j] = 1
                union = bfs(i, j)
                if len(union) > 1:
                    stop = True
                    div_number = sum([population[y][x] for y, x in union]) // len(union)

                    for y, x in union:
                        population[y][x] = div_number
    if not stop:
        break
    day += 1

print(day)