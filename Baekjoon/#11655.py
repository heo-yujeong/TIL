upper = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
lower = 'abcdefghijklmnopqrstuvwxyz'

S = input()
result = ''

for s in S:
    if s.isupper():
        for i in range(26):
            if s == upper[i]:
                if i + 13 < 26:
                    result += upper[i + 13]
                else:
                    result += upper[i - 13]
    elif s.islower():
        for i in range(26):
            if s == lower[i]:
                if i + 13 < 26:
                    result += lower[i + 13]
                else:
                    result += lower[i - 13]
    else:
        result += s

print(result)