import sys
input = sys.stdin.readline

def calc(n, x):
    if x == 1:
        return N

    v = calc(n, x//2)
    if x % 2 == 0:
        return v * v % X
    else:
        return v * v * n % X

M = int(input())
X = 1000000007
result = 0

for _ in range(M):
    N, S = map(int, input().split())
    result += S * calc(N, X-2) % X

print(result % X)