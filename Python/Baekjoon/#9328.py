import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    global cnt
    visit = [[0] * (w+2) for _ in range(h+2)]
    queue = deque()
    queue.append((0, 0))
    visit[0][0] = 1

    while queue:
        y, x = queue.popleft()

        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if 0 <= nx < w+2 and 0 <= ny < h+2 and not visit[ny][nx] and space[ny][nx] != '*':
                if 'A' <= space[ny][nx] <= 'Z':
                    if space[ny][nx].lower() not in key:
                        continue
                elif 'a' <= space[ny][nx] <= 'z':
                    if space[ny][nx] not in key:
                        key[space[ny][nx]] = True
                        visit = [[0] * (w+2) for _ in range(h+2)]
                elif space[ny][nx] == '$':
                    cnt += 1
                    space[ny][nx] = '.'

                visit[ny][nx] = 1
                queue.append((ny, nx))

T = int(input())

for _ in range(T):
    h, w = map(int, input().split())
    space = [['.'] + list(input()) + ['.'] for _ in range(h)]
    space = [['.'] * (w+2)] + space + [['.'] * (w+2)]
    key = {}
    for i in input():
        if i.isalpha():
            key[i] = True

    cnt = 0
    bfs()
    print(cnt)