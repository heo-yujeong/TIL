from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x):
    queue = deque()
    queue.append((y, x))
    cnt = 0

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visit[ny][nx] and maps[ny][nx]:
                maps[ny][nx] = 0
                visit[ny][nx] = 1
                cnt += 1
                queue.append((ny, nx))
    return cnt

N = int(input())
maps = [list(map(int, list(input()))) for _ in range(N)]
visit = [[0] * N for _ in range(N)]

cnt_house = []

for i in range(N):
    for j in range(N):
        if maps[i][j]:
            cnt_house.append(max(bfs(i, j), 1))

print(len(cnt_house))
cnt_house.sort()
print(*cnt_house, sep='\n')