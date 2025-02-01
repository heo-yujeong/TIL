T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    num_list = list(map(int, input().split()))
    num_list.sort()

    result = []
    for i in range(N):
        if i % 2 == 0:
            result.append(num_list.pop(-1))
        else:
            result.append(num_list.pop(0))
    
    print(f'#{test_case}', end=' ')
    print(*result[:10])