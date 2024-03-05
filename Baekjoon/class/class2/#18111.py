import sys

N, M, B = map(int, sys.stdin.readline().split())
ground = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

result = 256 * N * M
height = 0

for n in range(257):
    out_block = 0
    in_block = 0
    time = 0

    for i in range(N):
        for j in range(M):
            diff = ground[i][j] - n
            if diff > 0:
                out_block += diff
            if diff < 0:
                in_block += -diff

    if in_block > out_block + B:
        continue
    time = out_block * 2 + in_block

    if result >= time:
        result = time
        height = n

print(result, height)