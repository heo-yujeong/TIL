import sys
input = sys.stdin.readline

while True:
    line = input().rstrip('\n')

    if not line:
        break

    lower, upper, num, blank = 0, 0, 0, 0

    for char in line:
        if char.islower():
            lower += 1
        elif char.isupper():
            upper += 1
        elif char.isdigit():
            num += 1
        else:
            blank += 1

    print(lower, upper, num, blank)