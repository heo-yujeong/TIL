import sys
input = sys.stdin.readline

N = int(input())
seat = [[0]*N for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

students_like = [list(map(int, input().split())) for _ in range(N**2)]

for student, *likes in students_like:
    available = []

    for y in range(N):
        for x in range(N):
            if not seat[y][x]:
                like, empty = 0, 0

                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0 <= nx < N and 0 <= ny < N:
                        if seat[ny][nx] in likes:
                            like += 1
                        if not seat[ny][nx]:
                            empty += 1

                available.append([y, x, like, empty])

    available.sort(key=lambda x: (-x[2], -x[3], x[0], x[1]))
    seat[available[0][0]][available[0][1]] = student

hap = 0
score = [0, 1, 10, 100, 1000]
students_like.sort()

for y in range(N):
    for x in range(N):
        stati = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if seat[ny][nx] in students_like[seat[y][x]-1]:
                    stati += 1
        if stati != 0:
            hap += (10**(stati-1))

print(hap)