T = int(input())

for _ in range(T):
    N = int(input())
    cnt_0, cnt_1 = 1, 0

    for i in range(N):
        cnt_0, cnt_1 = cnt_1, cnt_0 + cnt_1

    print(cnt_0, cnt_1)