N = int(input())
result = 1
for i in range(1, N+1):
    result *= i
cnt = 0
for txt in str(result)[::-1]:
    if txt == '0':
        cnt += 1
    else:
        print(cnt)
        break