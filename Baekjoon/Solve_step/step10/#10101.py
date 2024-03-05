degree = []

for _ in range(3):
    degree.append(int(input()))

if sum(degree) == 180:
    if degree[0] == degree[1] == degree[2]:
        print('Equilateral')
    elif degree[0] == degree[1] or degree[1] == degree[2] or degree[0] == degree[2]:
        print('Isosceles')
    else:
        print('Scalene')
else:
    print('Error')