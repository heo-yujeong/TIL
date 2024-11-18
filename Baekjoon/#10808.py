alpha = 'abcdefghijklmnopqrstuvwxyz'
S = input()
cnt = [0] * 26

for s in S:
    cnt[alpha.index(s)] += 1

print(*cnt)