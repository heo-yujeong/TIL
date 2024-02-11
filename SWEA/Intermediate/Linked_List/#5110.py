T = int(input())

for test_case in range(1, T+1):
    N, M = map(int, input().split())

    arr = []

    for _ in range(M):
        if not arr:
            arr = list(map(int,input().split()))
        else:
            tmp = list(map(int,input().split()))
            for i in range(len(arr)):
                if tmp[0] < arr[i]:
                    arr[i:i] = tmp
                    break
            else:
                arr += tmp

    result = arr[-10:]
    print(f'#{test_case}', *result[::-1])