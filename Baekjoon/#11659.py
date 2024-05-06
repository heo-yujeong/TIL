import sys

N, M = map(int, sys.stdin.readline().split())
num_lst = list(map(int, sys.stdin.readline().split()))

sum_lst = []
hap = 0
for num in num_lst:
    hap += num
    sum_lst.append(hap)

for _ in range(M):
    i, j = map(int, sys.stdin.readline().split())

    if i == j:
        print(num_lst[i-1])
    elif i == 1:
        print(sum_lst[j-1])
    else:
        print(sum_lst[j-1]-sum_lst[i-2])