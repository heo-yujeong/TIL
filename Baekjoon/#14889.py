import sys
from itertools import combinations
input = sys.stdin.readline

def calc(team):
    hap = 0
    for i in range(len(team)-1):
        for j in range(i+1, len(team)):
            hap += S[team[i]][team[j]]
            hap += S[team[j]][team[i]]
    return hap

N = int(input())
S = [list(map(int, input().split())) for _ in range(N)]

min_diff = 100 * N
for combi in combinations(range(N), N//2):
    team_1 = []
    team_2 = []
    for i in range(N):
        if i in combi:
            team_1.append(i)
        else:
            team_2.append(i)

    hap_1 = calc(team_1)
    hap_2 = calc(team_2)

    diff = abs(hap_1-hap_2)
    min_diff = min(min_diff, diff)

print(min_diff)