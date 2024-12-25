N, M = map(int, input().split())
A = list(map(int, input().split()))

start, end = 0, 1
cnt = 0

while start <= end <= N:
    hap = sum(A[start:end])

    if hap < M:
        end += 1
    elif hap > M:
        start += 1
    else:
        cnt += 1
        end += 1

print(cnt)