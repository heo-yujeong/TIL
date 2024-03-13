N = int(input())
time_lst = list(map(int, input().split()))
time_lst.sort()
waiting_lst = [0] * (N+1)
for i in range(1, N+1):
    waiting_lst[i] = waiting_lst[i-1] + time_lst[i-1]

print(sum(waiting_lst))