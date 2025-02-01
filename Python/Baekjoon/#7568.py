N = int(input())
num_lst = [list(map(int, input().split())) for _ in range(N)]
order = []

for i in range(N):
    k = 0
    for j in range(N):
        if i != j:
            if num_lst[i][0] < num_lst[j][0] and num_lst[i][1] < num_lst[j][1]:
                k += 1
    order.append(k+1)

print(*order)