import sys
input = sys.stdin.readline

N = int(input().strip())
A = list(map(int, input().strip().split()))
M = int(input().strip())
B = list(map(int, input().strip().split()))

ans = []

while True:
    if not A or not B:
        break

    max_a = max(A)
    max_b = max(B)

    if max_a == max_b:
        ans.append(max_a)

        A = A[A.index(max_a) + 1:]
        B = B[B.index(max_b) + 1:]
    elif max_a > max_b:
        A.remove(max_a)
    else:
        B.remove(max_b)

if ans:
    print(len(ans))
    print(' '.join(map(str, ans)))
else:
    print(0)