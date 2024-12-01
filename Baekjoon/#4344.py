C = int(input())
for _ in range(C):
    N, *jumsu = map(int, input().split())
    avg = sum(jumsu) / N
    cnt = 0

    for i in range(N):
        if jumsu[i] > avg:
            cnt += 1

    print(f'{round((cnt / N) * 100, 3):.3f}%')