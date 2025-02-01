import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = [0] + list(map(int, input().split()))
C = [0] + list(map(int, input().split()))

dp = [[0] * (sum(C)+1) for _ in range(N+1)]
min_cost = sum(C)

for i in range(1, N+1):
    m = A[i]
    c = C[i]

    for j in range(sum(C)+1):
        if j < c:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(m+dp[i-1][j-c], dp[i-1][j])

for c in range(sum(C)+1):
    if dp[N][c] >= M:
        min_cost = min(min_cost, c)

print(min_cost if min_cost <= sum(C) else 0)