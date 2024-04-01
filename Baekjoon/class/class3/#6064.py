import sys
T = int(sys.stdin.readline())

for _ in range(T):
    M, N, x, y = map(int, sys.stdin.readline().split())

    year = x
    while year <= M * N:
        if (year - x) % M == 0 and (year - y) % N == 0:
            break
        year += M
    else:
        print(-1)
        continue

    print(year)