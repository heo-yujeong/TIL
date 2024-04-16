first = list(input())
second = list(input())

d = [0] * len(second)

for i in range(len(first)):
    cnt = 0
    for j in range(i, len(second)):
        if cnt < d[j]:
            cnt = d[j]
        elif first[i] == second[j]:
            d[j] = cnt + 1
        print(d, cnt)
print(max(d))