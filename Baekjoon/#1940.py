N = int(input())
M = int(input())
nums = list(map(int, input().split()))
nums.sort()

left, right = 0, N-1
cnt = 0

while left < right:
    hap = nums[left] + nums[right]

    if hap < M:
        left += 1
    elif hap > M:
        right -= 1
    else:
        cnt += 1
        left += 1
        right -= 1

print(cnt)