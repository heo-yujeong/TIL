T = int(input())

for test_case in range(1, T+1):
    N, M, K = map(int, input().split())
    arr = list(map(int, input().split()))
    idx = 0

    for _ in range(K):
        idx += M
        if idx > len(arr):
            idx -= len(arr)
        if idx == len(arr):
            arr.append(arr[-1]+arr[0])
        elif idx == 0:
            arr.insert(0, arr[-1]+arr[0])
        else:
            arr.insert(idx, arr[idx-1]+arr[idx])

    print(f'#{test_case}', *arr[-10:][::-1])