T = int(input())

for _ in range(T):
    A, B = map(int, input().split())

    x, y = A, B
    while y != 0:
        x, y = y, x%y

    print(A*B//x)