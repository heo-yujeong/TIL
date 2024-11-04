N = int(input())
wants = map(int, input().split())

hap = 0
for w in wants:
    if w <= N:
        hap += w
    else:
        hap += N

print(hap)