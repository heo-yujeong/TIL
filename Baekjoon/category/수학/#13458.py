import sys
input = sys.stdin.readline

N = int(input())
Ai = list(map(int, input().split()))
B, C = map(int, input().split())

cnt = 0

for i in range(N):
    if Ai[i] <= B:
        cnt += 1
    else:
        cnt += 1
        if (Ai[i]-B) % C == 0:
            cnt += ((Ai[i]-B) // C)
        else:
            cnt += (((Ai[i] - B) // C) + 1)

print(cnt)