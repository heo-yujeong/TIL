import sys
input = sys.stdin.readline

L = int(input())
S = list(map(int, input().split()))
n = int(input())

S.sort()

if n in S:
    print(0)
else:
    left = right = 0
    for s in S:
        if s < n:
            left = s
        elif s > n and right == 0:
            right = s
    right -= 1
    left += 1

    print((n-left)*(right-n+1) + (right-n))