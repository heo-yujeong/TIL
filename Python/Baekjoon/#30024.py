import sys
from heapq import heappush, heappop
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

N, M = map(int, input().split())
field = []
pq = []
visit = [[0] * M for _ in range(N)]

for i in range(N):
    line = list(map(int, input().split()))
    for j in range(M):
        if i == 0 or i == N-1 or j ==0 or j == M-1:
            heappush(pq, (-line[j], i, j))
            visit[i][j] = 1
    field.append(line)

K = int(input())
result = []

while pq:
    value, y, x = heappop(pq)
    if K == 0:
        break
    result.append([y + 1, x + 1])
    K -= 1

    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]
        if 0 <= nx < M and 0 <= ny < N and not visit[ny][nx]:
            visit[ny][nx] = 1
            heappush(pq, (-field[ny][nx], ny, nx))

for r in result:
    print(*r)