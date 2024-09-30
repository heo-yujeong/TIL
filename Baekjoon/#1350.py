N = int(input())
file = list(map(int, input().split()))
S = int(input())

cnt = N

for f in file:
    if f > S:
        cnt += (f-1) // S
    elif f == 0:
        cnt -= 1

print(S * cnt)