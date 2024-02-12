alpha = 'abcdefghijklmnopqrstuvwxyz'
S = input()

for al in alpha:
    if al in S:
        print(S.index(al), end=' ')
    else:
        print(-1, end=' ')