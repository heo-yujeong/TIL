T = int(input())

for test_case in range(1, T+1):
    K, N, M = map(int, input().split())
    stations = list(map(int, input().split()))

    loc = 0
    count = 0

    while loc + K < N:
        for step in range(K, 0, -1):
            if loc + step in stations:
                loc += step
                count += 1
                break
        else:
            count = 0
            break
    
    print(f'#{test_case} {count}')