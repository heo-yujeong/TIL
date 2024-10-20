books = {}
N = int(input())
for _ in range(N):
    title = input()

    if books.get(title):
        books[title] += 1
    else:
        books[title] = 1

max_cnt = max(books.values())
result = []

for k, v in books.items():
    if v == max_cnt:
        result.append(k)

result.sort()
print(result[0])