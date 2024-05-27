import sys
from itertools import permutations
input = sys.stdin.readline

def game(players, order):
    score = 0
    idx = 0

    for n in range(N):
        b1, b2, b3 = 0, 0, 0
        out = 0

        while out < 3:
            if players[n][order[idx]] == 0:
                out += 1
            elif players[n][order[idx]] == 1:
                score += b3
                b1, b2, b3 = 1, b1, b2
            elif players[n][order[idx]] == 2:
                score += (b2 + b3)
                b1, b2, b3 = 0, 1, b1
            elif players[n][order[idx]] == 3:
                score += (b1 + b2 + b3)
                b1, b2, b3 = 0, 0, 1
            elif players[n][order[idx]] == 4:
                score += (b1 + b2 + b3 + 1)
                b1, b2, b3 = 0, 0, 0
            idx = idx + 1 if idx + 1 < 9 else 0
    return score

N = int(input())
players = [list(map(int, input().split())) for _ in range(N)]
print(max(game(players, list(p)[:3] + [0] + list(p)[3:]) for p in permutations(range(1, 9), 8)))