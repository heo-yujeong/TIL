import sys
input = sys.stdin.readline

dx = [0, 0, 0, 1, -1]
dy = [0, -1, 1, 0, 0]

R, C, M = map(int, input().split())
shark = {}
for i in range(1, M+1):
    r, c, s, d, z = map(int, input().split())
    shark[(r, c)] = [s, d, z]

hap_shark = 0
idx = 0

while idx < C:
    idx += 1

    del_shark = None
    min_row = R+1
    for r, c in shark.keys():
        if c == idx and r < min_row:
            min_row = r
            del_shark = (r, c)

    if del_shark:
        hap_shark += shark[del_shark][2]
        del shark[del_shark]

    new_shark = {}
    for (r, c), (s, d, z) in shark.items():
        if d == 1 or d == 2:
            s %= (2 * (R - 1))
        else:
            s %= (2 * (C - 1))

        for _ in range(s):
            if d == 1 and r == 1:
                d = 2
            elif d == 2 and r == R:
                d = 1
            elif d == 3 and c == C:
                d = 4
            elif d == 4 and c == 1:
                d = 3

            r += dy[d]
            c += dx[d]

        if (r, c) in new_shark:
            if new_shark[(r, c)][2] < z:
                new_shark[(r, c)] = [s, d, z]
        else:
            new_shark[(r, c)] = [s, d, z]

    shark = new_shark

print(hap_shark)