T = int(input())

for test_case in range(1, T+1):
    N, M = map(int, input().split())
    str_board = [input() for _ in range(N)]
    result = ''

    for i in range(N):
        for j in range(N-M+1):
            if str_board[i][j:j+M] == str_board[i][j:j+M][::-1]:
                result = str_board[i][j:j+M]
    
    trans_str_board = [''.join(list(x)) for x in zip(*str_board)]
    for i in range(N):
        for j in range(N-M+1):
            if trans_str_board[i][j:j+M] == trans_str_board[i][j:j+M][::-1]:
                result = trans_str_board[i][j:j+M]

    print(f'#{test_case} {result}')