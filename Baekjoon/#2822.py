jumsu = []
for i in range(1, 9):
    j = int(input())

    jumsu.append([i, j])

jumsu.sort(key=lambda x:x[1], reverse=True)
hap = 0
numbers = []
for i in range(5):
    hap += jumsu[i][1]
    numbers.append(jumsu[i][0])

numbers.sort()
print(hap)
print(*numbers)