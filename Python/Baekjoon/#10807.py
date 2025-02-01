N = int(input())
num_list = list(map(int, input().split()))
v = int(input())

result = 0
for num in num_list:
    if num == v:
        result += 1

print(result)