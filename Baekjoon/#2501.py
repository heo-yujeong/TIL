N, K = map(int, input().split())

yaksu = []
for i in range(1, N+1):
    if N % i == 0:
        yaksu.append(i)

if len(yaksu) >= K:
    print(yaksu[K-1])
else:
    print(0)