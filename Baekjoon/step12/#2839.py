n = int(input())
cnt = []

for a in range(n):
    for b in range(n):
        if 5 * a + 3 * b == n:
            cnt.append(a + b)

if cnt:
    print(min(cnt))
else:
    print(-1)