dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(y, x, chr_num):
    if len(chr_num) == 6:
        result.add(chr_num)
        return

    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]
        if 0 <= nx < 5 and 0 <= ny < 5:
            dfs(ny, nx, chr_num+board[ny][nx])

board = [list(input().split()) for _ in range(5)]
result = set()
for i in range(5):
    for j in range(5):
        dfs(i, j, board[i][j])

print(len(result))