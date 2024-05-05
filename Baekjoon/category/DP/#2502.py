def search():
    for a in range(1, K):
        for b in range(a, K):
            d = [0] * (D + 1)
            d[1] = a
            d[2] = b

            for day in range(3, D + 1):
                d[day] = d[day - 2] + d[day - 1]

            if d[D] == K:
                return a, b


D, K = map(int, input().split())
result_a, result_b = search()

print(result_a)
print(result_b)