import sys
input = sys.stdin.readline

n, k, x = map(int, input().split())
people = [list(map(int, input().split())) for i in range(n)]

dp = [[0] * (x*k+1) for _ in range(k+1)]

for a, b in people:
    for i in range(k-1, 0, -1):
        for j in range(x*k, a-1, -1):
            dp[i+1][j] = dp[i+1][j] or dp[i][j-a]

    dp[1][a] = 1

result = 0
for i in range(x*k+1):
    if dp[k][i]:
        result = max(result, i * (x*k-i))

print(result)