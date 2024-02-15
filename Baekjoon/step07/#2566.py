board = [list(map(int, input().split())) for _ in range(9)]

max_num = 0
row = col = 0

for i in range(9):
    for j in range(9):
        if board[i][j] >= max_num:
            max_num = board[i][j]
            row, col = i+1, j+1

print(max_num)
print(row, col)