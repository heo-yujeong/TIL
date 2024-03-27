oper = input().split('-')

mid = []

for o in oper:
    mid.append(sum(map(int, o.split('+'))))

result = mid[0]

for num in mid[1:]:
    result -= num

print(result)