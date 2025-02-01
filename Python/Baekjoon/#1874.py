n = int(input())
stack = []
result = []
flag = 0
num = 1
for _ in range(n):
    in_num = int(input())
    while in_num >= num:
        stack.append(num)
        result.append('+')
        num += 1

    if stack[-1] == in_num:
        stack.pop()
        result.append('-')
    else:
        print('NO')
        flag = 1
        break

if not flag:
    print(*result, sep='\n')