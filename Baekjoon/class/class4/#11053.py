import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

d = [1] * N

for i in range(N):
    for j in range(i):
        if A[i] > A[j]:
            d[i] = max(d[j]+1, d[i])

print(max(d))