import sys
input = sys.stdin.readline

N = int(input())
lst = list(map(int, input().split()))
T, P = map(int, input().split())

T_cnt = 0

for num in lst:
    if num == 0:
        continue
    elif num <= T:
        T_cnt += 1
    elif num % T == 0:
        T_cnt += (num // T)
    else:
        T_cnt += (num // T) + 1

P_cnt = N // P
p = N % P

print(T_cnt)
print(P_cnt, p)