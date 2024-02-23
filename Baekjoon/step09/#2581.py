M = int(input())
N = int(input())

sosu = []

for i in range(M, N+1):
    if i == 1:
        continue
    for j in range(2, i):
        if i % j == 0:
            break
    else:
        sosu.append(i)

if sosu:
    print(sum(sosu))
    print(min(sosu))
else:
    print(-1)