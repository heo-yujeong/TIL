import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    coins = list(map(int, input().split()))
    M = int(input())

    d = [0] * (M+1)
    d[0] = 1

    for coin in coins:
        for i in range(coin, M+1):
            d[i] += d[i-coin]

    print(d[-1])