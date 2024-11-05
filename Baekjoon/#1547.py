M = int(input())
cup = [1, 2, 3]

for _ in range(M):
    X, Y = map(int, input().split())
    idx1, idx2 = cup.index(X), cup.index(Y)
    cup[idx1], cup[idx2] = cup[idx2], cup[idx1]

print(cup[0])