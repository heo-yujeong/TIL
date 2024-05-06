T = int(input())

for test_case in range(1, T+1):
    str1 = input()
    str2 = input()

    result = {}
    for i in str2:
        if i in set(str1):
            result[i] = result.get(i, 0) + 1

    print(f'#{test_case} {max(result.values())}')