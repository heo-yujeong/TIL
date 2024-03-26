t = int(input())

for _ in range(t):
    closet = {}
    n = int(input())
    for _ in range(n):
        name, cat = input().split()
        if cat in closet:
            closet[cat].append(name)
        else:
            closet[cat] = [name]

    cnt = 1
    for clo in closet:
        cnt *= (len(closet[clo]) + 1)

    print(cnt-1)