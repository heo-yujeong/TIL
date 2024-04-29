import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    num_lst = set(map(int, input().split()))
    M = int(input())
    chk_lst = list(map(int, input().split()))

    for num in chk_lst:
        if num in num_lst:
            print(1)
        else:
            print(0)