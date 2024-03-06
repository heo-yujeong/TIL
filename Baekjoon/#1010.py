T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    n1 = n2 = n3 = 1
    for i in range(1, N+1):
        n1 *= i
    for i in range(1, M-N+1):
        n2 *= i
    for i in range(1, M+1):
        n3 *= i

    result = n3 // (n1 * n2)
    print(result)