G = int(input())
before = [i for i in range(1, 100001)]
after = [i for i in range(1, 100001)]

left, right = 0, 0
result = []

while left < 100000 and right < 100000:
    cha = (after[right] + before[left]) * (after[right] - before[left])
    if cha == G:
        result.append(after[right])
    if cha < G:
        right += 1
        continue
    left += 1

if not result:
    print(-1)
else:
    print(*result, sep='\n')