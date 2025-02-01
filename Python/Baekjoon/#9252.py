first = [''] + list(input())
second = [''] + list(input())

d = [[''] * len(second) for _ in range(len(first))]

for i in range(1, len(first)):
    for j in range(1, len(second)):
        if first[i] == second[j]:
            d[i][j] = d[i-1][j-1] + first[i]
        else:
            if len(d[i-1][j]) >= len(d[i][j-1]):
                d[i][j] = d[i-1][j]
            else:
                d[i][j] = d[i][j-1]

result = d[-1][-1]
print(len(result))
if len(result) > 0:
    print(result)