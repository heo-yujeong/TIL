import sys
from collections import deque
input = sys.stdin.readline

def calc(chr_num):
    visit = set()
    queue = deque()
    queue.append((chr_num, ''))

    while queue:
        chr_num, oper_lst = queue.popleft()
        for oper in ['D', 'S', 'L', 'R']:
            if oper == 'D':
                tmp = (2 * int(chr_num)) % 10000
                cal_chr_num = four_space(str(tmp))
            elif oper == 'S':
                tmp = int(chr_num)-1 if int(chr_num) != 0 else 9999
                cal_chr_num = four_space(str(tmp))
            elif oper == 'L':
                cal_chr_num = chr_num[1:]+chr_num[0]
            else:
                cal_chr_num = chr_num[3] + chr_num[:3]

            calc_oper_list = oper_lst + oper
            if cal_chr_num == B:
                return calc_oper_list
            if cal_chr_num in visit:
                continue
            else:
                visit.add(cal_chr_num)
            queue.append((cal_chr_num, calc_oper_list))

def four_space(chr_num):
    return '0'*(4-len(chr_num)) + chr_num

T = int(input())
for _ in range(T):
    A, B = list(map(four_space, input().split()))

    result = calc(A)

    print(result)