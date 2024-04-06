import sys
from collections import deque
input = sys.stdin.readline

def calc(num):
    visit = set()
    queue = deque()
    queue.append((num, ''))

    while queue:
        num, oper_lst = queue.popleft()
        for oper in ['D', 'S', 'L', 'R']:
            if oper == 'D':
                cal_num = (num * 2) % 10000
            elif oper == 'S':
                cal_num = num - 1 if num != 0 else 9999
            elif oper == 'L':
                d1, d2, d3, d4 = num//1000, (num//100)%10, (num//10)%10, num%10
                cal_num = d2*1000 + d3*100 + d4*10 + d1
            else:
                d1, d2, d3, d4 = num//1000, (num//100)%10, (num//10)%10, num%10
                cal_num = d4*1000 + d1*100 + d2*10 + d3

            calc_oper_list = oper_lst + oper
            if cal_num == B:
                return calc_oper_list
            if cal_num in visit:
                continue
            else:
                visit.add(cal_num)
            queue.append((cal_num, calc_oper_list))

T = int(input())
for _ in range(T):
    A, B = list(map(int, input().split()))

    result = calc(A)

    print(result)