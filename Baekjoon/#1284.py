while True:
    N = input()
    if N == '0':
        break

    width = 0
    for i in range(len(N)):
        if N[i] == '1':
            width += 2
        elif N[i] == '0':
            width += 4
        else:
            width += 3

    width += (len(N) + 1)
    print(width)