T = int(input())

for test_case in range(1, T+1):
    code = input()

    stack_list = []
    result = 0

    for char in code:
        if char in '({':
            stack_list.append(char)
        elif char in ')}':
            if stack_list and ((stack_list[-1] == '{' and char == '}') or (stack_list[-1] == '(' and char == ')')):
                stack_list.pop()
            else:
                break
    else:
        if not stack_list:
            result = 1

    print(f'#{test_case} {result}')