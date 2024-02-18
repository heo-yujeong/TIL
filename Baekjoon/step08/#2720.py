T = int(input())

unit = [25, 10, 5, 1]
unit_count = [0] * 4

for _ in range(T):
    money = int(input())
    for i in range(len(unit)):
        unit_count[i] = money // unit[i]
        money -= unit[i] * unit_count[i]

    print(*unit_count)