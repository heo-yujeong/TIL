N = int(input())
solution = list(map(int, input().split()))

left, right = 0, N-1
result_left, result_right = 0, 0
limit_0 = float('inf')

while left < right:
    hap = solution[left] + solution[right]

    if abs(hap) < limit_0:
        result_left, result_right = left, right
        limit_0 = abs(hap)

    if hap > 0:
        right -= 1
    elif hap < 0:
        left += 1
    else:
        break

print(solution[result_left], solution[result_right])