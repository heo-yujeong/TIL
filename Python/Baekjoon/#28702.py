for i in [3, 2, 1]:
    temp = input()

    if temp not in ['Fizz', 'Buzz', 'FizzBuzz']:
        result = int(temp) + i

if result % 3 == 0 and result % 5 == 0:
    print('FizzBuzz')
elif result % 3 == 0:
    print('Fizz')
elif result % 5 == 0:
    print('Buzz')
else:
    print(result)