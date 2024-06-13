import sys
input = sys.stdin.readline

def mul(arr1, arr2):
    result = [[0]*N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            for k in range(N):
                result[i][j] += arr1[i][k] * arr2[k][j]
            result[i][j] %= 1000
    return result

def square(A, B):
    if B == 1:
        for i in range(len(A)):
            for j in range(len(A)):
                A[i][j] %= 1000
        return A
    tmp = square(A, B//2)
    if B % 2:
        return mul(mul(tmp, tmp), A)
    else:
        return mul(tmp, tmp)

N, B = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]

result = square(A, B)
for r in result:
    print(*r)