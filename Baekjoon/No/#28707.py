N = int(input())
A = list(map(int, input().split()))
M = int(input())
oper = []

for _ in range(M):
    l, r, c = map(int, input().split())
    oper.append((l, r, c))
