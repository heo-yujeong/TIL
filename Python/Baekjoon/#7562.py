from collections import deque

dx = [-2, -1, 1, 2, 2, 1, -1, -2]
dy = [-1, -2, -2, -1, 1, 2, 2, 1]

t = int(input())
for _ in range(t):
    I = int(input())
    start_x, start_y = map(int, input().split())
    end_x, end_y = map(int, input().split())
    visit = [[0] * I for _ in range(I)]
    visit[start_y][start_x] = 1

    queue = deque()
    queue.append((start_y, start_x))

    while queue:
        y, x = queue.popleft()
        if y == end_y and x == end_x:
            print(visit[y][x] - 1)
            break
        for d in range(8):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < I and 0 <= ny < I and not visit[ny][nx]:
                visit[ny][nx] = visit[y][x] + 1
                queue.append((ny, nx))