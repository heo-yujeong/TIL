T = int(input())

for test_case in range(1, T+1):
    N, M = map(int, input().split())
    structure = [list(map(int, input().split())) for _ in range(N)]

    max_cnt = 0

    for i in range(N):
        cnt = 0
        for j in range(M):
            if structure[i][j] == 1:
                cnt += 1
                if max_cnt < cnt:
                    max_cnt = cnt
            else:
                cnt = 0

    for j in range(M):
        cnt = 0
        for i in range(N):
            if structure[i][j] == 1:
                cnt += 1
                if max_cnt < cnt:
                    max_cnt = cnt
            else:
                cnt = 0

    print(f'#{test_case} {max_cnt}')