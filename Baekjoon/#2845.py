L, P = map(int, input().split())
choose = list(map(int, input().split()))

total = L * P
for num in choose:
    print(num-total, end=' ')