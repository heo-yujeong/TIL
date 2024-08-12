N = int(input())
now = N
cnt = 0

while True:
    if next == N:
        break

    hap = (now % 10) + (now // 10)
    next = (now % 10)*10 + (hap % 10)
    cnt += 1
    now = next

print(cnt)