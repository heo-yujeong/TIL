N = int(input())
num_list = list(map(int, input().split()))
num_set_list = list(set(num_list))
num_set_list.sort()
num_dict = {}

for idx, num in enumerate(num_set_list):
    num_dict[num] = idx
for num in num_list:
    print(num_dict[num], end=' ')