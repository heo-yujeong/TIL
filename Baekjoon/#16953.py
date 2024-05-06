import sys
input = sys.stdin.readline

def calc(num, cnt):
    global min_cnt
    if num == B:
        min_cnt = min(min_cnt, cnt)
        return
    if num > B:
        return
    calc(num*2, cnt+1)
    calc(num*10+1, cnt+1)

A, B = map(int, input().split())

min_cnt = B - A + 1

calc(A, 0)

if min_cnt == B-A+1:
    print(-1)
else:
    print(min_cnt+1)