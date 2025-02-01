Case = 1

while True:
    L, P, V = map(int, input().split())
    if L == P == V == 0:
        break

    result = (V // P) * L
    result += min((V % P), L)
    print(f'Case {Case}: {result}')
    Case += 1