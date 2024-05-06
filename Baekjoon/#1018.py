N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]

min_cnt = []

for i in range(N-7):
    for j in range(M-7):
        cnt_f_b = 0
        cnt_f_w = 0
        for k in range(i, i+8):
            for l in range(j, j+8):
                if k % 2 == 0:
                    if l % 2 == 0:
                        if board[k][l] != 'B':
                            cnt_f_b += 1
                    else:
                        if board[k][l] != 'W':
                            cnt_f_b += 1
                else:
                    if l % 2 == 0:
                        if board[k][l] != 'W':
                            cnt_f_b += 1
                    else:
                        if board[k][l] != 'B':
                            cnt_f_b += 1

                if k % 2 == 0:
                    if l % 2 == 0:
                        if board[k][l] != 'W':
                            cnt_f_w += 1
                    else:
                        if board[k][l] != 'B':
                            cnt_f_w += 1
                else:
                    if l % 2 == 0:
                        if board[k][l] != 'B':
                            cnt_f_w += 1
                    else:
                        if board[k][l] != 'W':
                            cnt_f_w += 1

        min_cnt.append(cnt_f_b)
        min_cnt.append(cnt_f_w)

print(min(min_cnt))