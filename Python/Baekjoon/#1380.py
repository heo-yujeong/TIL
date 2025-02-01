result = []

while True:
    n = int(input())
    if n == 0:
        break

    names = [input() for _ in range(n)]
    numbers = []

    for _ in range(2*n-1):
        A, B = input().split()
        if A not in numbers:
            numbers.append(A)
        else:
            numbers.remove(A)

    result.append(names[int(numbers[0]) - 1])

for idx, name in enumerate(result):
    print(idx+1, name)