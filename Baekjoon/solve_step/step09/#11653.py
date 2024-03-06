N = int(input())

idx = 2
while N > 1:
    if N % idx == 0:
        print(idx)
        N //= idx
    else:
        idx += 1