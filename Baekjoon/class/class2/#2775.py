T = int(input())

for _ in range(T):
    k = int(input())
    n = int(input())
    peo_num = [[i for i in range(n+1)] for _ in range(k+1)]

    for i in range(1, k+1):
        for j in range(1, n+1):
            peo_num[i][j] = peo_num[i-1][j] + peo_num[i][j-1]
    print(peo_num[k][n])