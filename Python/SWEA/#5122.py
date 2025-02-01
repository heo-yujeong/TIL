T = int(input())

for test_case in range(1, T+1):
    N, M, L = map(int, input().split())
    arr = list(map(int, input().split()))

    for _ in range(M):
        edit = input().split()
        if edit[0] == 'I':
            arr.insert(int(edit[1]), int(edit[2]))
        elif edit[0] == 'D':
            arr.pop(int(edit[1]))
        elif edit[0] == 'C':
            arr[int(edit[1])] = int(edit[2])

    if len(arr)-1 < L:
        result = -1
    else:
        result = arr[L]

    print(f'#{test_case} {result}')