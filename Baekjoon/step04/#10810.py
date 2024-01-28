N, M = map(int, input().split())

basket = [0 for _ in range(N+1)]

for m in range(M):
    i, j, k = map(int, input().split())
    for idx in range(i, j+1):
        basket[idx] = k
print(*basket[1:])