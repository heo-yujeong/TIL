# 시작 위치 : 1, 1, 방향 : 오른쪽

# 벽이나 자기자신의 몸에 부딪히면 게임 끝
# 이동 칸에 사과가 있다면 사과 업어지고 꼬리 그대로
# 사과가 없다면 머리는 앞으로, 꼬리는 한칸 줄어듦

from collections import deque

# 우하좌상
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

N = int(input())
K = int(input())
snake = deque()
snake.append((1, 1))
apple = set()
for _ in range(K):
    r, c = map(int, input().split())
    apple.add((r, c))

L = int(input())
time = 0
d = 0
flag = False
for _ in range(L):
    X, C = input().split()
    print(X, C)
    X = int(X)

    while True:
        time += 1
        X -= 1
        nx = snake[-1][1] + dx[d]
        ny = snake[-1][0] + dy[d]

        if 1 <= nx <= N and 1 <= ny <= N:
            if (ny, nx) in snake:
                flag = True
                break
            snake.append((ny, nx))
            if (ny, nx) in apple:
                apple.remove((ny, nx))
            else:
                snake.popleft()
        else:
            flag = True
            break

        if X == 0:
            break

    if flag:
        break
    if C == 'L':
        d = (d - 1) % 4
    else:
        d = (d + 1) % 4

print(apple)
print(time)