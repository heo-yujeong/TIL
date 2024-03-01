N = int(input())
lst = list(map(int, input().split()))
max_len = 1
cnt = 1

for i in range(len(lst)-1):
    if lst[i] <= lst[i+1]:
        cnt += 1
        if max_len < cnt:
            max_len = cnt
    else:
        cnt = 1
cnt = 1
for i in range(len(lst)-1, 0, -1):
    if lst[i-1] >= lst[i]:
        cnt += 1
        if max_len < cnt:
            max_len = cnt
    else:
        cnt = 1

print(max_len)