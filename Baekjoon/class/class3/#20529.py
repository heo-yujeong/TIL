import sys
from itertools import combinations
T = int(input())

for _ in range(T):
    N = int(sys.stdin.readline())
    mbti = sys.stdin.readline().split()
    mbti_dist = 12
    if len(mbti) > 32:
        print(0)
        continue
    else:
        for comb in combinations(mbti, 3):
            dist = len(set(comb[0]+comb[1])) + len(set(comb[1]+comb[2])) + len(set(comb[2]+comb[0])) - 12

            mbti_dist = min(mbti_dist, dist)

        print(mbti_dist)