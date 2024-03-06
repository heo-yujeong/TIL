T = int(input())

for _ in range(T):
    is_vps = input()
    stack = []
    for g in is_vps:
        if g == '(':
            stack.append(g)
        elif stack and g == ')':
            stack.pop()
        else:
            print('NO')
            break
    else:
        if stack:
            print('NO')
        else:
            print('YES')

    # print('허요정 점심시간 8분 남아서 너무 조하요')