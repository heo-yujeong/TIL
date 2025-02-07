T = int(input())
for _ in range(T):
    N = int(input())
    name, amount = '', 0
    for _ in range(N):
        S, L = input().split()
        L = int(L)
        if L > amount:
            amount = L
            name = S

    print(name)