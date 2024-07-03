import sys
from collections import deque
input = sys.stdin.readline

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, 1, -1] 

def bfs(z, y, x):
  queue = deque()
  queue.append((z, y, x))
  visit[z][y][x] = 0

  while queue:
    now_z, now_y, now_x = queue.popleft()
    for i in range(6):
      next_z, next_y, next_x = now_z+dz[i], now_y+dy[i], now_x+dx[i]
      if 0 <= next_z < L and 0 <= next_y < R and 0 <= next_x < C:
        if building[next_z][next_y][next_x] == 'E':
          return visit[now_z][now_y][now_x] + 1
        if building[next_z][next_y][next_x] == '.' and visit[next_z][next_y][next_x] == -1:
          visit[next_z][next_y][next_x] = visit[now_z][now_y][now_x] + 1
          queue.append((next_z, next_y, next_x))
  return -1

while True:
  L, R, C = map(int, input().split())
  if L == R == C == 0:
    break

  building = []
  visit = [[[-1] * C for _ in range(R)] for _ in range(L)]
  x, y, z = 0, 0, 0

  for k in range(L):
    area = []
    for i in range(R):
      line = list(input())
      for j in range(C):
        if line[j] == 'S':
          x, y, z = j, i, k
      area.append(line)
    building.append(area)
    space = input()

  time = bfs(z, y, x)

  if time == -1:
    print('Trapped!')
  else:
    print(f'Escaped in {time} minute(s).')