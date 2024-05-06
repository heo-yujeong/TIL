while True:
    num1, num2 = map(int, input().split())

    if num1 == num2 == 0:
        break
    else:
        yaksu = []
        for i in range(1, num2+1):
            if num2 % i == 0:
                yaksu.append(i)

        if num1 in yaksu:
            print('factor')
        elif num1 % num2 == 0:
            print('multiple')
        else:
            print('neither')