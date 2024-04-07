import sys
from itertools import combinations
input = sys.stdin.readline

N, M = map(int, input().split())
house = []
chicken = []
min_len = (abs(N-1) + abs(N-1)) ** (N * 2)

for i in range(N):
    city = list(map(int, input().split()))

    for j in range(N):
        if city[j] == 1:
            house.append([i, j])
        if city[j] == 2:
            chicken.append([i, j])

for select in combinations(chicken, M):
    dist = 0
    for h in house:
        chick_len = N ** 2
        for i in range(M):
            chick_len = min(chick_len, abs(h[0]-select[i][0])+abs(h[1]-select[i][1]))
        dist += chick_len
    min_len = min(min_len, dist)

print(min_len)