import sys
input = sys.stdin.readline

N, M = map(int, input().split())
train = [0] * N

for _ in range(M):
    order = list(map(int, input().split()))

    if order[0] == 1:
        i, x = order[1]-1, order[2]-1
        train[i] = train[i] | (1 << x)

    elif order[0] == 2:
        i, x = order[1]-1, order[2]-1
        train[i] = train[i] & ~(1 << x)

    elif order[0] == 3:
        i = order[1]-1
        train[i] = train[i] << 1
        train[i] = train[i] & ~(1 << 20)

    else:
        i = order[1]-1
        train[i] = train[i] >> 1

print(len(set(train)))