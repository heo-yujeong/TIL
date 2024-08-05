import sys
input = sys.stdin.readline

N, M = map(int, input().split())

min_pack = 1001
min_one = 1001

for _ in range(M):
    pack, one = map(int, input().split())
    min_pack, min_one = min(min_pack, pack), min(min_one, one)

cost = 0

if min_pack > min_one*6:
    cost += N * min_one
else:
    cost += (N//6) * min_pack
    cost += min(min_pack, (N%6)*min_one)

print(cost)