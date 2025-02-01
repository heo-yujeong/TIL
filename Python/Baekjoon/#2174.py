import sys
input = sys.stdin.readline

A, B = map(int, input().split())
N, M = map(int, input().split())
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

robots = {}
for num in range(N):
    x, y, z = input().split()
    if z == 'N':
        d = 0
    elif z == 'E':
        d = 1
    elif z == 'S':
        d = 2
    else:
         d = 3
    robots[num+1] = [int(x), int(y), d]

for _ in range(M):
    num, order, cnt = input().split()
    num = int(num)
    cnt = int(cnt)

    x, y, d = robots[num]
    if order == 'L':
        d = (d - cnt) % 4
    elif order == 'R':
        d = (d + cnt) % 4
    elif order == 'F':
        for _ in range(cnt):
            x += dx[d]
            y += dy[d]
            if x > A or y > B or x <= 0 or y <= 0:
                print(f'Robot {num} crashes into the wall')
                exit(0)
            for k, v in robots.items():
                if k != num:
                    nx, ny, nd = v
                    if (x, y) == (nx, ny):
                        print(f'Robot {num} crashes into robot {k}')
                        exit(0)
    robots[num] = [x, y, d]

print('OK')