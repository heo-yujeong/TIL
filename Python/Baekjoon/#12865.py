import sys
input = sys.stdin.readline

N, K = map(int, input().split())
bag = []
for _ in range(N):
    W, V = map(int, input().split())
    bag.append([W, V])

dp = [[0]*(K+1) for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, K+1):
        w, v = bag[i-1]
        if j < w:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-w]+v)

print(dp[N][K])