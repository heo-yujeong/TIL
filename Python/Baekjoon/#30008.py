N, K = map(int, input().split())
scores = list(map(int, input().split()))
result = []

for score in scores:
    P = (score*100) // N

    if 0 <= P <= 4:
        result.append(1)
    elif 4 < P <= 11:
        result.append(2)
    elif 11 < P <= 23:
        result.append(3)
    elif 23 < P <= 40:
        result.append(4)
    elif 40 < P <= 60:
        result.append(5)
    elif 60 < P <= 77:
        result.append(6)
    elif 77 < P <= 89:
        result.append(7)
    elif 89 < P <= 96:
        result.append(8)
    else:
        result.append(9)

print(*result)