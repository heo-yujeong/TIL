while True:
    num_lst = sorted(list(map(int, input().split())))
    if sum(num_lst) == 0:
        break
    if (num_lst[0] ** 2 + num_lst[1] ** 2) == (num_lst[2] ** 2):
        print('right')
    else:
        print('wrong')