import sys
sys.stdin = open('input.txt')

R, C, N = map(int, input().split())
N = int(N)
board = [input() for _ in range(R)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

if N <= 1:
    for i in board:
        print(''.join(i))
elif N % 2 == 0:
    for i in range(R):
        print('O' * C)
else:
    later_1 = [['O'] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if board[i][j] == 'O':
                later_1[i][j] = '.'
                for k in range(4):
                    nx = i + dx[k]
                    ny = j + dy[k]
                    if 0 <= nx < R and 0 <= ny < C:
                        later_1[nx][ny] = '.'

    later_2 = [['O'] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if later_1[i][j] == 'O':
                later_2[i][j] = '.'
                for k in range(4):
                    nx = i + dx[k]
                    ny = j + dy[k]
                    if 0 <= nx < R and 0 <= ny < C:
                        later_2[nx][ny] = '.'

    if N % 4 == 3:
        for i in later_1:
            print(''.join(i))
    elif N % 4 == 1:
        for i in later_2:
            print(''.join(i))