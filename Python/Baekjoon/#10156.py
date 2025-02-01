K, N, M = map(int, input().split())
cha = K * N - M

if cha < 0:
    cha = 0

print(cha)