import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(y, x):
    global max_len
    queue = set([(y, x, board[0][0])])

    while queue:
        y, x, alpha_lst = queue.pop()
        max_len = max(max_len, len(alpha_lst))

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < C and 0 <= ny < R and board[ny][nx] not in alpha_lst:
                queue.add((ny, nx, alpha_lst+board[ny][nx]))

R, C = map(int, input().split())
board = [list(input()) for _ in range(R)]

max_len = 0
bfs(0, 0)

print(max_len)