S = int(input())
hap = 0
cnt = 0

while True:
    cnt += 1
    hap += cnt

    if hap > S:
        cnt -= 1
        break

print(cnt)