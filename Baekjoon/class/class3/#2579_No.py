N = int(input())
stair = [0] + [int(input()) for _ in range(N)]

d = [0] * 301

d[1] = stair[1]
d[2] = stair[1] + stair[2]
if N >= 3:
    d[3] = max(stair[1]+stair[3], stair[2]+stair[3])
for i in range(4, N+1):
    d[i] = max(d[i-3]+stair[i-1]+stair[i], d[i-2]+stair[i])
print(stair)
print(d)
print(d[N])