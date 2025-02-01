import sys
input = sys.stdin.readline

N = int(input())
solution = list(map(int, input().split()))
solution.sort()

limit_0 = float('inf')
lst = []

for i in range(N-2):
    fix = solution[i]
    left = i+1
    right = N-1

    while left < right:
        hap = fix + solution[left] + solution[right]

        if abs(hap) < abs(limit_0):
            lst = [fix, solution[left], solution[right]]
            limit_0 = hap

        if hap > 0:
            right -= 1
        elif hap < 0:
            left += 1
        else:
            print(*lst)
            sys.exit()

print(*lst)