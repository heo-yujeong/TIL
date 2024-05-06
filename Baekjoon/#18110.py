def round_func(n):
    return int(n) + (1 if n - int(n) >= 0.5 else 0)

n = int(input())

if n == 0:
    print(0)
else:
    op = []
    for _ in range(n):
        op.append(int(input()))
    op.sort()
    rnd = round_func(n * 0.15)
    op = op[rnd: n-rnd]

    print(round_func(sum(op)/(n-2*rnd)))