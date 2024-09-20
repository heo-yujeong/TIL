A, B = map(int, input().split())
C = int(input())

if 2*C > A+B:
    print(A+B)
else:
    print((A+B) - 2*C)