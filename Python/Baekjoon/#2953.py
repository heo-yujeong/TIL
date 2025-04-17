max_idx, max_jumsu = 1, 0
for i in range(1, 6):
    jumsu_lst = list(map(int, input().split()))
    hap = sum(jumsu_lst)
    if hap > max_jumsu:
        max_jumsu = hap
        max_idx = i

print(max_idx, max_jumsu)