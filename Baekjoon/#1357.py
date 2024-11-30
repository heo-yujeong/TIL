def Rev(X):
    return int(X[::-1])

X, Y = input().split()
print(Rev(str(Rev(X)+Rev(Y))))