X, Y, W, S = map(int, input().split())

one = (X + Y) * W

if (X + Y) % 2 == 0:
    two = max(X, Y) * S
else:
    two = (max(X, Y) - 1) * S + W

three = min(X, Y) * S + abs(X - Y) * W

print(min(one, two, three))