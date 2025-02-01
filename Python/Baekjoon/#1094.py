X = int(input())

count = 0
x = 64

while X > 0:
    if x > X:
        x //= 2
    else:
        count += 1
        X -= x

print(count)