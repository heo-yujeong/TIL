import sys
input = sys.stdin.readline

H, W = map(int, input().split())
height = list(map(int, input().split()))

total = 0

for i in range(1, W-1):
    left = max(height[:i])
    right = max(height[i+1:])

    cnt = min(left, right)

    if height[i] < cnt:
        total += (cnt - height[i])

print(total)