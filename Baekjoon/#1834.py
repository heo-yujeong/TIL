N = int(input())
hap = 0

for i in range(1, N):
    hap += (N * i + i)

print(hap)