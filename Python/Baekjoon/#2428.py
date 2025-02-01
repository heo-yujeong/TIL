N = int(input())
file_size = sorted(map(int, input().split()))
cnt = 0

for i in range(N):
    start, end = i, N-1

    while start <= end:
        middle = (start + end) // 2
        if file_size[i] >= file_size[middle] * 0.9:
            start = middle + 1
        else:
            end = middle - 1

    cnt += (start-i-1)

print(cnt)