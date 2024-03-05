N = int(input())
num_lst = [int(input()) for _ in range(N)]
num_lst.sort()

for num in num_lst:
    print(num)