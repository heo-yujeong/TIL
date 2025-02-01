import sys
input = sys.stdin.readline

def binary(n):
    start = 0
    end = len(lst)-1

    while start <= end:
        mid = (start+end) // 2

        if lst[mid] == n:
            return mid
        elif lst[mid] < n:
            start = mid + 1
        else:
            end = mid - 1
    return start

N = int(input())
A = list(map(int, input().split()))

lst = [A[0]]

for i in range(N):
    if A[i] > lst[-1]:
        lst.append(A[i])
    else:
        idx = binary(A[i])
        lst[idx] = A[i]

print(len(lst))