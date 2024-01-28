N, M = map(int, input().split())

basket = [i for i in range(N+1)]

for m in range(M):
    i, j = map(int, input().split())
    basket[i], basket[j] = basket[j], basket[i]

print(*basket[1:])