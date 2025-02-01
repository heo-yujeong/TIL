N = int(input())
cnt = 0
for _ in range(N):
    d_day = int(input()[2:])
    if d_day <= 90:
        cnt += 1

print(cnt)