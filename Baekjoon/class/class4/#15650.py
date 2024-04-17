def backtrack(length, lst):
    if length == M:
        result.append(lst)
    for i in range(1, N+1):
        if not check[i]:
            if lst:
                if lst[-1] < i:
                    check[i] = 1
                    backtrack(length+1, lst+[i])
                    check[i] = 0
            else:
                check[i] = 1
                backtrack(length+1, lst+[i])
                check[i] = 0

N, M = map(int, input().split())
check = [0] * (N+1)

result = []

backtrack(0, [])

for r in result:
    print(*r)