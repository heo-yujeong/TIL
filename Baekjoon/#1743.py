import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x):
    queue = deque()
    queue.append((y, x))
    graph[y][x] = 0
    cnt = 1

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < M and 0 <= ny < N and graph[ny][nx] == 1:
                queue.append((ny, nx))
                graph[ny][nx] = 0
                cnt += 1

    return cnt

N, M, K = map(int, input().split())
graph = [[0]*M for _ in range(N)]

for _ in range(K):
    r, c = map(int, input().split())
    graph[r-1][c-1] = 1

result = 0
for i in range(N):
    for j in range(M):
        if graph[i][j]:
            result = max(result, bfs(i, j))

print(result)