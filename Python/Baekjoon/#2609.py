num1, num2 = map(int, input().split())

# 최소공배수
x, y = num1, num2
while y > 0:
    x, y = y, x%y

# 최대공약수
a, b = num1, num2
while b:
    if a > b:
        a, b = b, a
    b %= a
print((num1*num2)//(num1*num2//x))
print(num1*num2//x)