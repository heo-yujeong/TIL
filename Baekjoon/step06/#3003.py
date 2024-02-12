sum = [1, 1, 2, 2, 2, 8]
count = list(map(int, input().split()))

result = [0] * len(sum)

for idx in range(len(sum)):
    result[idx] = sum[idx] - count[idx]

print(*result)