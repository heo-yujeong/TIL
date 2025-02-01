import sys
from collections import deque
input = sys.stdin.readline

di = [-1, 1, 0, 0]
dj = [0, 0, -1, 1]

def bfs(i, j, size):
    visit = [[-1] * N for _ in range(N)]
    queue = deque()
    queue.append([i, j])
    visit[i][j] = 0
    eat_fish = []

    while queue:
        i, j = queue.popleft()
        for d in range(4):
            ni, nj = i + di[d], j + dj[d]
            if 0 <= ni < N and 0 <= nj < N and visit[ni][nj] == -1:
                if space[ni][nj] <= size:
                    visit[ni][nj] = visit[i][j] + 1
                    queue.append([ni, nj])
                    if 1 <= space[ni][nj] < size:
                        eat_fish.append([visit[ni][nj], ni, nj])
    if not eat_fish:
        return -1, i, j, 0
    eat_fish.sort()
    dist, ni, nj = eat_fish[0]
    space[ni][nj] = 0
    return dist, ni, nj, 1

N = int(input())
space = []
x, y = 0, 0
size = 2
fish_eaten = 0
total_time = 0

for i in range(N):
    line = list(map(int, input().split()))
    for j in range(N):
        if line[j] == 9:
            x, y = j, i
            line[j] = 0
    space.append(line)

while True:
    dist, y, x, eaten = bfs(y, x, size)
    if dist == -1:
        break
    total_time += dist
    fish_eaten += eaten
    if fish_eaten == size:
        size += 1
        fish_eaten = 0

print(total_time)