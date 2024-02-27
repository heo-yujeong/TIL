lst = list(map(int, input().split()))

hap = 0
for num in lst:
    hap += num**2

print(hap%10)