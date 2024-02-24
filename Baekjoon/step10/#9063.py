N = int(input())

x_list = []
y_list = []

for _ in range(N):
    x, y = map(int, input().split())
    x_list.append(x)
    y_list.append(y)

if len(x_list) == len(y_list) == 1:
    print(0)
else:
    print((max(x_list)-min(x_list)) * (max(y_list)-min(y_list)))