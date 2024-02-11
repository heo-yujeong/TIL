dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def dfs(x, y):
    global result
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < N:
            if miro[nx][ny] == 3:
                result = 1
                return
            elif miro[nx][ny] == 0:
                miro[nx][ny] = 1
                dfs(nx, ny)


T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    miro = [list(map(int, input())) for _ in range(N)]

    for i in range(N):
        for j in range(N):
            if miro[i][j] == 2:
                start_x, start_y = i, j

    result = 0
    dfs(start_x, start_y)

    print(f'#{test_case} {result}')