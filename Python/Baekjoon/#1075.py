N = int(input())
F = int(input())
n = (N//100) * 100

while n % F != 0:
    n += 1

print(str(n)[-2:])