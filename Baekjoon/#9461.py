import sys
d = [0] * 101
d[1] = 1
d[2] = 1
d[3] = 1
for i in range(4, 101):
    d[i] = d[i-2] + d[i-3]

T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    print(d[N])