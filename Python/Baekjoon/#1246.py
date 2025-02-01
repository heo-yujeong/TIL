import sys
input = sys.stdin.readline

N, M = map(int, input().split())
P = [int(input()) for _ in range(M)]
P.sort()

result = 0
price = 0

for i in range(M):
    cnt = M-i

    if N <= cnt:
        hap = N * P[i]
    else:
        hap = cnt * P[i]

    if hap > result:
        result = hap
        price = P[i]

print(price, result)