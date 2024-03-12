N, K = map(int, input().split())
ai = [int(input()) for _ in range(N)]
cnt = 0

for i in range(N-1, -1, -1):
    if ai[i] <= K:
        cnt += K // ai[i]
        K %= ai[i]
        if K == 0:
            break

print(cnt)