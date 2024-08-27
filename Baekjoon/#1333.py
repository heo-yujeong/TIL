import sys
input = sys.stdin.readline

N, L, D = map(int, input().split())

time = L
bell = D

for i in range(1, N+1):
    if bell >= time - L and bell < time:
        while bell < time:
            bell += D
        time += 5 + L
    elif bell >= time and bell < time + 5:
        break
    else:
        time += 5 + L

print(bell)