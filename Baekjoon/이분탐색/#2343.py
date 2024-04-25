import sys
input = sys.stdin.readline

N, M = map(int, input().split())
lectures = list(map(int, input().split()))

start = max(lectures)
end = sum(lectures)

while start <= end:
    middle = (start + end) // 2

    total = 0
    cnt = 1
    for lect in lectures:
        if total + lect > middle:
            cnt += 1
            total = 0
        total += lect

    if cnt <= M:
        result = middle
        end = middle - 1
    else:
        start = middle + 1

print(result)