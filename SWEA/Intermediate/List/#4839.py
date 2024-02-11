T = int(input())

for test_case in range(1, T+1):
    a_count = 0
    b_count = 0
    a_start = 1
    b_start = 1
    last, a_page, b_page = map(int, input().split())
    a_last = last
    b_last = last

    while True:
        a_mid = int((a_start + a_last)/2)
        a_count += 1
        if a_mid == a_page:
            break
        elif a_mid > a_page:
            a_last = a_mid
        else:
            a_start = a_mid

    while True:
        b_mid = int((b_start + b_last)/2)
        b_count += 1
        if b_mid == b_page:
            break
        elif b_mid > b_page:
            b_last = b_mid
        else:
            b_start = b_mid

    result = ''
    if a_count == b_count:
        result = '0'
    elif a_count < b_count:
        result = 'A'
    else:
        result = 'B'

    print(f'#{test_case} {result}')