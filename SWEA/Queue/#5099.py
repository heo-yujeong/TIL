import sys
sys.stdin = open('input.txt')

T = int(input())

for test_case in range(1, T+1):
    N, M = map(int, input().split())
    pizza = list(map(int, input().split()))

    pizza_idx = list([i+1, piz] for i, piz in enumerate(pizza))

    oven = pizza_idx[:N]
    wait = pizza_idx[N:]

    while len(oven) > 1:
        pizze_check = oven.pop(0)
        pizze_check[1] //= 2
        if pizze_check[1] == 0:
            if wait:
                oven.append(wait.pop(0))
        else:
            oven.append(pizze_check)

    print(f'#{test_case} {oven[0][0]}')