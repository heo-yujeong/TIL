cnt = 0

for i in range(8):
    line = list(input())
    for j in range(8):
        if i % 2 == 0:
            if j % 2 == 0 and line[j] == 'F':
                cnt += 1
        else:
            if j % 2 == 1 and line[j] == 'F':
                cnt += 1

print(cnt)