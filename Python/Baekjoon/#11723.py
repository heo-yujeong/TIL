import sys
S = set()

M = int(sys.stdin.readline())
for _ in range(M):
    order = sys.stdin.readline().split()
    if order[0] == 'add':
        if int(order[1]) not in S:
            S.add(int(order[1]))
    elif order[0] == 'remove':
        if int(order[1]) in S:
            S.remove(int(order[1]))
    elif order[0] == 'check':
        if int(order[1]) in S:
            print(1)
        else:
            print(0)
    elif order[0] == 'toggle':
        if int(order[1]) in S:
            S.remove(int(order[1]))
        else:
            S.add(int(order[1]))
    elif order[0] == 'all':
        S = {i for i in range(1, 21)}
    else:
        S = set()