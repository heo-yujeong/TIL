while True:
    line = input()

    if line == '#':
        break

    cnt = 0
    for txt in line:
        if txt in 'aeiouAEIOU':
            cnt += 1
    print(cnt)