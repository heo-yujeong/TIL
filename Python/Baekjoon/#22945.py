import sys
input = sys.stdin.readline

N = int(input())
xi = list(map(int, input().split()))

left, right = 0, N-1
result = 0

while left < right:
    result = max(result, (right-left-1) * min(xi[left], xi[right]))

    if xi[left] < xi[right]:
        left += 1
    else:
        right -= 1

print(result)