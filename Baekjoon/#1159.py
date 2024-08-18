'''
alpha = 'abcdefghijklmnopqrstuvwxyz'
count = [0] * len(alpha)

N = int(input())
for _ in range(N):
    name = input()
    count[alpha.index(name[0])] += 1

if max(count) >= 5:
    for i in range(len(count)):
        if count[i] >= 5:
            print(alpha[i], end='')
else:
    print('PREDAJA')
'''

N = int(input())
players = []
possible = []

for _ in range(N):
    name = input()
    players.append(name[0])

first_name = set(players)
for p in first_name:
    if players.count(p) >= 5:
        possible.append(p)

if len(possible):
    print(''.join(sorted(possible)))
else:
    print('PREDAJA')