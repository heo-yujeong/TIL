def check(shape):
    cnt = 0
    if board[0] == board[1] == board[2] == shape:
        cnt += 1
    if board[3] == board[4] == board[5] == shape:
        cnt += 1
    if board[6] == board[7] == board[8] == shape:
        cnt += 1
    if board[0] == board[3] == board[6] == shape:
        cnt += 1
    if board[1] == board[4] == board[7] == shape:
        cnt += 1
    if board[2] == board[5] == board[8] == shape:
        cnt += 1
    if board[0] == board[4] == board[8] == shape:
        cnt += 1
    if board[2] == board[4] == board[6] == shape:
        cnt += 1
    return cnt

while True:
    board = input()
    if board == 'end':
        break
    o_cnt = board.count('O')
    x_cnt = board.count('X')
    o_win = check('O')
    x_win = check('X')

    if x_win > o_win and x_cnt == o_cnt+1:
        print('valid')
    elif x_win < o_win and x_cnt == o_cnt:
        print('valid')
    elif x_win == o_win == 0 and x_cnt == 5 and o_cnt == 4:
        print('valid')
    else:
        print('invalid')