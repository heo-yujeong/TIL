import sys
input = sys.stdin.readline

N, m, M, T, R = map(int, input().split())
time = result = 0
heart = m

if m + T > M:
    print(-1)
else:
    while time < N:
        if heart + T <= M:
            heart += T
            time += 1
            result += 1
        else:
            heart -= R
            if heart < m:
                heart = m
            result += 1

    print(result)