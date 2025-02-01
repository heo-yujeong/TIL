import sys
from collections import deque
input = sys.stdin.readline

def bfs(x, y):
    queue = deque()
    queue.append([x, y])

    while queue:
        x, y = queue.popleft()
        if abs(x-festival[0]) + abs(y-festival[1]) <= 1000:
            print('happy')
            return
        for i in range(n):
            if not visit[i]:
                if abs(x-conven[i][0]) + abs(y-conven[i][1]) <= 1000:
                    queue.append([conven[i][0], conven[i][1]])
                    visit[i] = 1
    print('sad')

t = int(input())

for _ in range(t):
    n = int(input())
    house = list(map(int, input().split()))
    conven = [list(map(int, input().split())) for _ in range(n)]
    festival = list(map(int, input().split()))

    visit = [0] * n

    bfs(house[0], house[1])