N = int(input())
num_lst = []
num_dict = {}
hap = 0
for _ in range(N):
    num = int(input())
    num_lst.append(num)
    hap += num
    if num not in num_dict:
        num_dict[num] = 1
    else:
        num_dict[num] += 1

num_lst.sort()
freq = max(num_dict.values())
freq_lst = []

for k, v in num_dict.items():
    if freq == v:
        freq_lst.append(k)


print(round(hap/N))
print(num_lst[N//2])

if len(freq_lst) >= 2:
    print(sorted(freq_lst)[1])
else:
    print(freq_lst[0])

print(num_lst[-1] - num_lst[0])