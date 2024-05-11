def backtrack(num):
    if len(num_lst) == M:
        print(*num_lst)
        return

    for i in range(num, N+1):
        num_lst.append(i)
        backtrack(i)
        num_lst.pop()

N, M = map(int, input().split())
num_lst = []
backtrack(1)