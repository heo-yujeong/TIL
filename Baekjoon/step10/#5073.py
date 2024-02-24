while True:
    lst = list(map(int, input().split()))
    lst.sort()

    if sum(lst) == 0:
        break
    elif lst[2] >= lst[0] + lst[1]:
        print('Invalid')
    else:
        if lst[0] == lst[1] == lst[2]:
            print('Equilateral')
        elif lst[0] == lst[1] or lst[1] == lst[2] or lst[0] == lst[2]:
            print('Isosceles')
        else:
            print('Scalene')