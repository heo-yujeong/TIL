import sys
input = sys.stdin.readline

X, Y = map(int, input().split())
Z = (Y * 100) // X

if Z >= 99:
    print(-1)
else:
    cnt = 0
    start = 1
    end = X

    while start <= end:
        middle = (start + end) // 2

        if ((Y+middle) * 100) // (X+middle) <= Z:
            start = middle + 1
        else:
            cnt = middle
            end = middle - 1
    print(cnt)