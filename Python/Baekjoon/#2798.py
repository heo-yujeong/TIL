# from itertools import combinations
#
# N, M = map(int, input().split())
# card = list(map(int, input().split()))
# result =0
# comb = list(combinations(card, 3))
#
# for com in comb:
#     if sum(com) <= M:
#         if result < sum(com):
#             result = sum(com)
#
# print(result)

def card_comb(com, hap):
    global result
    if len(com) == 3:
        if result < hap <= M:
            result = hap
    elif hap > M:
        return
    else:
        for i in range(N):
            if not include[i]:
                include[i] = 1
                card_comb(com+[card[i]], hap+card[i])
                include[i] = 0

N, M = map(int, input().split())
card = list(map(int, input().split()))
result = 0
include = [0] * (N+1)

card_comb([], 0)

print(result)