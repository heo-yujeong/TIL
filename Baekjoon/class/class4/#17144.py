import sys
input = sys.stdin.readline

def spread():
    di = [-1, 1, 0, 0]
    dj = [0, 0, -1, 1]
    plus = [[0] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if Arc[i][j] > 0:
                minus = 0
                for k in range(4):
                    ni = i + di[k]
                    nj = j + dj[k]
                    if 0 <= ni < R and 0 <= nj < C and Arc[ni][nj] != -1:
                        plus[ni][nj] += (Arc[i][j] // 5)
                        minus += (Arc[i][j] // 5)
                Arc[i][j] -= minus
    for i in range(R):
        for j in range(C):
            Arc[i][j] += plus[i][j]

def air_up(clean_i, clean_j):
    di = [-1, 0, 1, 0]
    dj = [0, 1, 0, -1]
    i, j = clean_i-1, clean_j
    dir = 0
    while True:
        ni = i + di[dir]
        nj = j + dj[dir]
        if ni == clean_i and nj == clean_j:
            Arc[i][j] = 0
            break
        if ni < 0 or ni > clean_i or nj < 0 or nj >= C:
            dir += 1
            continue
        Arc[i][j] = Arc[ni][nj]
        i, j = ni, nj

def air_down(clean_i, clean_j):
    di = [1, 0, -1, 0]
    dj = [0, 1, 0, -1]
    i, j = clean_i+1, clean_j
    dir = 0
    while True:
        ni = i + di[dir]
        nj = j + dj[dir]
        if ni == clean_i and nj == clean_j:
            Arc[i][j] = 0
            break
        if ni < clean_i or ni >= R or nj < 0 or nj >= C:
            dir += 1
            continue
        Arc[i][j] = Arc[ni][nj]
        i, j = ni, nj


R, C, T = map(int, input().split())
Arc = [list(map(int, input().split())) for _ in range(R)]

clean = []

for i in range(R):
    if Arc[i][0] == -1:
        clean.append(i)
    if len(clean) == 2:
        break

for _ in range(T):
    spread()
    air_up(clean[0], 0)
    air_down(clean[1], 0)

result = 0
for i in range(R):
    for j in range(C):
        if Arc[i][j] > 0:
            result += Arc[i][j]

print(result)