N, M = map(int, input().split())
height = list(map(int, input().split()))

start = 0
end = max(height)

while start <= end:
    center = (start + end) // 2
    hap = 0
    for h in height:
        if h > center:
            hap += (h-center)
    if hap >= M:
        result = center
        start = center+1
    elif hap < M:
        end = center-1

print(result)