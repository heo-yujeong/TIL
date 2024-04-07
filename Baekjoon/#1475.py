N = list(map(int, list(input())))

count = [0] * 9

for num in N:
    if num == 9:
        count[6] += 1
    else:
        count[num] += 1

if count[6] % 2 == 0:
    count[6] //= 2
else:
    count[6] = count[6] // 2 + 1

print(max(count))