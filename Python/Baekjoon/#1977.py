M = int(input())
N = int(input())
sqrt = []

for i in range(M, N+1):
    num = int(i ** 0.5) ** 2
    if i == num:
        sqrt.append(i)

if sqrt:
    print(sum(sqrt))
    print(min(sqrt))
else:
    print(-1)