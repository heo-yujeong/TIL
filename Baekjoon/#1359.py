from itertools import combinations

N, M, K = map(int, input().split())
comb = list(combinations(range(N), M))
result = 0

for c in comb:
    cnt = 0
    for i in range(M):
        if c[i] < M:
            cnt += 1
    if cnt >= K:
        result += 1

print(result / len(comb))