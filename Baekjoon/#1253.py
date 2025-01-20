import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
A.sort()

cnt = 0

for i in range(N):
    goal = A[:i] + A[i+1:]
    start, end = 0, len(goal)-1

    while start < end:
        if goal[start] + goal[end] == A[i]:
            cnt += 1
            break
        elif goal[start] + goal[end] < A[i]:
            start += 1
        else:
            end -= 1

print(cnt)