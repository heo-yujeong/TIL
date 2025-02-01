N, M = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
B = [list(map(int, input().split())) for _ in range(N)]
sumAB = [[0] * M for _ in range(N)]

for i in range(N):
    for j in range(M):
        sumAB[i][j] = A[i][j] + B[i][j]

for AB in sumAB:
    print(*AB)