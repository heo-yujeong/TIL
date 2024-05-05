import sys
input = sys.stdin.readline

def budget_calc(start, end):
    global result

    if start > end:
        return
    middle = (start + end) // 2
    total = 0
    for r in require:
        if middle <= r:
            total += middle
        else:
            total += r

    if total <= M:
        result = middle
        return budget_calc(middle+1, end)
    else:
        return budget_calc(start, middle-1)

N = int(input())
require = list(map(int, input().split()))
M = int(input())

result = 0
budget_calc(0, max(require))

print(result)