N = int(input())

for i in range(N, 0, -1):
    print(' '*(N-i), end='')
    print('*'*i, end='')
    print()