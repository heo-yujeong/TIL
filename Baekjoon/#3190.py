import sys
from collections import deque
input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

N = int(input())
K = int(input())
snake = deque()
x, y = 1, 1
snake.append((1, 1))
apple = set()
for _ in range(K):
    r, c = map(int, input().split())
    apple.add((r, c))
L = int(input())
turn = []
for _ in range(L):
    X, C = input().split()
    turn.append((int(X), C))

time = 0
d = 0
idx = 0

while True:
    nx = x + dx[d]
    ny = y + dy[d]

    if 1 <= nx <= N and 1 <= ny <= N and (ny, nx) not in snake:
        if (ny, nx) in apple:
            apple.remove((ny, nx))
        else:
            snake.popleft()
        snake.append((ny, nx))
    else:
        time += 1
        break
    time += 1
    x, y = nx, ny
    if idx < len(turn) and time == turn[idx][0]:
        if turn[idx][1] == 'L':
            d = (d - 1) % 4
        else:
            d = (d + 1) % 4
        idx += 1

print(time)