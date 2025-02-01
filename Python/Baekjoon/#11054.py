import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

inc = [1] * N
dec = [1] * N

for i in range(N):
    for j in range(i):
        if A[i] > A[j]:
            inc[i] = max(inc[i], inc[j]+1)

for i in range(N-1, -1, -1):
    for j in range(N-1, i, -1):
        if A[i] > A[j]:
            dec[i] = max(dec[i], dec[j]+1)

hap = [0] * N
for i in range(N):
    hap[i] = inc[i] + dec[i] - 1

print(max(hap))