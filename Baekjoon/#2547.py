T = int(input())

for _ in range(T):
    _ = input()
    N = int(input())
    hap = 0
    for _ in range(N):
        hap += int(input())

    if hap % N:
        print('NO')
    else:
        print('YES')