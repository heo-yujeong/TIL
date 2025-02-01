lv, evaluation = input().split()

if evaluation == 'miss':
    print(0)
elif evaluation == 'bad':
    print(200 * int(lv))
elif evaluation == 'cool':
    print(400 * int(lv))
elif evaluation == 'great':
    print(600 * int(lv))
else:
    print(1000 * int(lv))