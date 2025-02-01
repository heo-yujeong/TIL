import sys
from itertools import combinations
input = sys.stdin.readline

N, M = map(int, input().split())
liked = [list(map(int, input().split())) for _ in range(N)]
max_hap = 0

for comb in combinations(range(M), 3):
    hap = 0
    for i in range(N):
        hap += max(liked[i][comb[0]], liked[i][comb[1]], liked[i][comb[2]])
    max_hap = max(max_hap, hap)

print(max_hap)