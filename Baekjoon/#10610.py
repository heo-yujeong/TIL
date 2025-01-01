N = input()

if '0' not in N:
    print(-1)
else:
    hap = 0
    for n in N:
        hap += int(n)

    if hap % 3 != 0:
        print(-1)
    else:
        sorted_N = sorted(N, reverse=True)
        print(''.join(sorted_N))