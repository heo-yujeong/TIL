import sys
input = sys.stdin.readline

xs, ys = map(int, input().split())
xe, ye, dx, dy = map(int, input().split())

if dx != 0 and dy != 0:
    for i in range(1, min(abs(dx)+1, abs(dy)+1)):
        if abs(dx) % i == 0 and abs(dy) % i == 0:
            gcf = i
    dx, dy = dx//gcf, dy//gcf

if dx == 0:
    if dy > 0:
        dy = 1
    elif dy < 0:
        dy = -1

if dy == 0:
    if dx > 0:
        dx = 1
    elif dx < 0:
        dy=x = -1

answer = float('inf')

while True:
    d = (xs-xe)**2 + (ys-ye)**2
    if answer > d:
        answer = d
    else:
        break

    xe += dx
    ye += dy

print(xe-dx, ye-dy)