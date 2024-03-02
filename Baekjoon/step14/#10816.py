import sys
N = int(sys.stdin.readline())
num_lst = list(map(int, sys.stdin.readline().split()))
cnt_dict = {}
for num in num_lst:
    if num in cnt_dict:
        cnt_dict[num] += 1
    else:
        cnt_dict[num] = 1

M = int(sys.stdin.readline())
find_lst = list(map(int, sys.stdin.readline().split()))
result = []
for num in find_lst:
    result.append(cnt_dict.get(num, 0))
print(*result)