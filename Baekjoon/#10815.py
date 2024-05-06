N = int(input())
num_list = set(map(int, input().split()))
M = int(input())
chk_list = list(map(int, input().split()))
for num in chk_list:
    if num in num_list:
        print(1, end=' ')
    else:
        print(0, end=' ')