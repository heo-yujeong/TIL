import sys
input = sys.stdin.readline

def row(y, n):
    for i in range(9):
        if n == board[y][i]:
            return False
    return True

def col(x, n):
    for i in range(9):
        if n == board[i][x]:
            return False
    return True

def ract(y, x, n):
    nx, ny = x // 3 * 3, y // 3 * 3
    for i in range(3):
        for j in range(3):
            if n == board[ny+i][nx+j]:
                return False
    return True

def backtrack(n):
    if n == len(blank):
        for _ in range(9):
            print(*board[_])
        exit(0)

    for i in range(1, 10):
        y, x = blank[n][0], blank[n][1]

        if row(y, i) and col(x, i) and ract(y, x, i):
            board[y][x] = i
            backtrack(n + 1)
            board[y][x] = 0

board = []
blank = []
for i in range(9):
    line = list(map(int, input().split()))
    board.append(line)
    for j in range(9):
        if board[i][j] == 0:
            blank.append([i, j])

backtrack(0)