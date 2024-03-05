da = [1, 2, 3, 4, 5, 6, 7, 8]
umm = list(map(int, input().split()))

if umm == da:
    print('ascending')
elif umm == da[::-1]:

    print('descending')
else:
    print('mixed')