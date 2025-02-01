people = [0] * 4

for i in range(4):
    out_num, in_num = map(int, input().split())
    if i == 0:
        people[i] = in_num
    else:
        people[i] = people[i-1] - out_num + in_num

print(max(people))