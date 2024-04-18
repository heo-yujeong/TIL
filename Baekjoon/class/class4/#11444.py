def fibo(num):
    if num == 0:
        return 0
    if num <= 2:
        return 1
    if d.get(num) != None:
        return d[num]
    if num % 2 == 0:
        d[num//2+1] = fibo(num//2+1) % 1000000007
        d[num//2-1] = fibo(num//2-1) % 1000000007
        return d[num//2+1] ** 2 - d[num//2-1] ** 2
    else:
        d[num//2+1] = fibo(num//2+1) % 1000000007
        d[num//2] = fibo(num//2) % 1000000007
        return d[num//2+1] ** 2 + d[num//2] ** 2

n = int(input())

d = {}
print(fibo(n) % 1000000007)