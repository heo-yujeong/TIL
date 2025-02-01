import sys
from collections import deque
input = sys.stdin.readline

di = [-1, -1, 0, 1, 1, 1, 0, -1]
dj = [0, 1, 1, 1, 0, -1, -1, -1]

def spring_summer():
    for i in range(N):
        for j in range(N):
            for k in range(len(tree[i][j])):
                if field[i][j] < tree[i][j][k]:
                    for _ in range(k, len(tree[i][j])):
                        dead_tree[i][j].append(tree[i][j].pop())
                    break
                else:
                    field[i][j] -= tree[i][j][k]
                    tree[i][j][k] += 1

    for i in range(N):
        for j in range(N):
            while dead_tree[i][j]:
                field[i][j] += dead_tree[i][j].pop() // 2

def fall_winter():
    for i in range(N):
        for j in range(N):
            for k in range(len(tree[i][j])):
                if tree[i][j][k] % 5 == 0:
                    for d in range(8):
                        ni, nj = i + di[d], j + dj[d]
                        if 0 <= ni < N and 0 <= nj < N:
                            tree[ni][nj].appendleft(1)

            field[i][j] += A[i][j]


N, M, K = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
field = [[5] * N for _ in range(N)]
tree = [[deque() for _ in range(N)] for _ in range(N)]
dead_tree = [[list() for _ in range(N)] for _ in range(N)]

for _ in range(M):
    x, y, z = map(int, input().split())
    tree[x-1][y-1].append(z)

for i in range(K):
    spring_summer()
    fall_winter()

result = 0
for i in range(N):
    for j in range(N):
        result += len(tree[i][j])

print(result)