N, M = map(int, input().split())

know_num, *know_lst = map(int, input().split())
know_lst = set(know_lst)

party_lst = []
for _ in range(M):
    poe_num, *people = map(int, input().split())
    party_lst.append(set(people))

for _ in range(M):
    for party in party_lst:
        if party & know_lst:
            know_lst = know_lst.union(party)

cnt = 0
for party in party_lst:
    if party & know_lst:
        continue
    cnt += 1

print(cnt)