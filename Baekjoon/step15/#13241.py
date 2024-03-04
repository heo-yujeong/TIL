A, B = map(int, input().split())
gob = A * B

while B:
    if A > B:
        A, B = B, A
    B %= A

print(gob//A)