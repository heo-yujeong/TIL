N = int(input())
consult = [list(map(int, input().split())) for _ in range(N)]
dp = [0] * (N+1)
#
# for i in range(N-1, -1, -1):
#     if i + consult[i][0] > N:
#         dp[i] = dp[i+1]
#     else:
#         dp[i] = max(dp[i+1], consult[i][1]+dp[i+consult[i][0]])
#
# print(dp[0])

for i in range(N):
    for j in range(i+consult[i][0], N+1):
        if dp[j] < dp[i]+consult[i][1]:
            dp[j] = dp[i] + consult[i][1]

print(dp[-1])