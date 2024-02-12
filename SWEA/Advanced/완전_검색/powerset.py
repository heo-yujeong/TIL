arr = [2, 3, 4, 5]
bit = [0] * len(arr)

for i in range(2):
    bit[0] = i
    for j in range(2):
        bit[1] = j
        for k in range(2):
            bit[2] = k
            for l in range(2):
                bit[3] = l
                print([arr[x] for x in range(len(bit)) if bit[x]])


print('---바이너리 카운팅---')
# 바이너리 카운팅
n = len(arr)
for i in range(1 << n):
    subset = []
    for j in range(n):
        if i & (1 << j):
            subset.append(arr[j])
    print(subset)