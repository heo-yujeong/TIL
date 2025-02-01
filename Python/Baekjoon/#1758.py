import sys
input = sys.stdin.readline

N = int(input())
tip_lst = [int(input()) for _ in range(N)]
tip_lst.sort(reverse=True)

result = 0

for i in range(N):
    tip = tip_lst[i] - i

    if tip > 0:
        result += tip

print(result)