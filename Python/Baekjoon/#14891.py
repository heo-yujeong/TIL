import sys
input = sys.stdin.readline

def rotate(num, dir):
    check[num] = 1
    if num > 0:
        if gears[num][6] != gears[num-1][2] and not check[num-1]:
            rotate(num-1, -dir)
    if num < 3:
        if gears[num][2] != gears[num+1][6] and not check[num+1]:
            rotate(num+1, -dir)

    if dir == 1:
        gears[num] = [gears[num][-1]] + gears[num][:-1]
    else:
        gears[num] = gears[num][1:] + [gears[num][0]]

gears = [list(map(int, list(input().rstrip()))) for _ in range(4)]
K = int(input())
for _ in range(K):
    num, dir = map(int, input().split())
    check = [0] * 4
    rotate(num-1, dir)

jumsu = 0
for i in range(len(gears)):
    if gears[i][0]:
        jumsu += 2 ** i

print(jumsu)