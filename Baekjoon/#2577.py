multi = 1
for _ in range(3):
    multi *= int(input())

counts = [0] * 10

for num in str(multi):
    counts[int(num)] += 1

print(*counts, sep='\n')