import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = list(map(int, input().split()))

start, end = 0, max(A)*M
result = 0

while start <= end:
    middle = (start+end) // 2
    balloon = 0

    for i in A:
        balloon += middle//i

    if balloon < M:
        start = middle + 1
    else:
        end = middle - 1
        result = middle

print(result)