x = []
y = []

for _ in range(3):
    a, b = map(int, input().split())
    x.append(a)
    y.append(b)

result_x = 0
result_y = 0

if x[0] == x[1]:
    result_x = x[2]
elif x[0] == x[2]:
    result_x = x[1]
else:
    result_x = x[0]

if y[0] == y[1]:
    result_y = y[2]
elif y[0] == y[2]:
    result_y = y[1]
else:
    result_y = y[0]

print(result_x, result_y)