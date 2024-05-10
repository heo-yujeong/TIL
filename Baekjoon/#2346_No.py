import sys
input = sys.stdin.readline

N = int(input())
balloon = list(map(int, input().split()))

visit = [0] * N
idx = 0
num = balloon[idx]

while True:
    if sum(visit) == N:
        break
    if not visit[idx]:
        visit[idx] = 1
        print(idx+1, end= ' ')
        num = balloon[idx]
        idx = (idx + balloon[idx]) % N
    else:
        while True:
            if not visit[idx]:
                break
            if num > 0:
                idx = (idx + 1) % N
            else:
                idx = (idx - 1) % N