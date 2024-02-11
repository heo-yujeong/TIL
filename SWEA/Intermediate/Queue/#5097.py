T = int(input())

for test_case in range(1, T+1):
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))

    for i in range(M):
        num = arr.pop(0)
        arr.append(num)

    print(f'#{test_case} {arr[0]}')