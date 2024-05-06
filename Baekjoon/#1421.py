# N: 나무개수, C: 자르는 비용, W: 나무 한단위 가격
# 길이가 L일때 벌 수 있는 금액 = K * L * W
N, C, W = map(int, input().split())
length = [int(input()) for _ in range(N)]

max_money = 0

for l in range(1, max(length)+1):
    money_sum = 0
    for tree in length:
        if tree % l == 0:
            c = (tree//l-1) * C
        else:
            c = tree//l * C
        money = (tree//l * l * W) - c
        if money < 0:
            continue
        money_sum += money

    if max_money < money_sum:
        max_money = money_sum

print(max_money)