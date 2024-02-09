T = int(input())

for test_case in range(1, T+1):
    code_list = input().split()

    stack = []

    for code in code_list:
        if code == '.':
            if len(stack) == 1:
                result = stack.pop()
            else:
                result = 'error'
        elif code in '+-*/':
            if len(stack) >= 2:
                num1 = stack.pop()
                num2 = stack.pop()
                if code == '+':
                    stack.append(num2 + num1)
                elif code == '-':
                    stack.append(num2 - num1)
                elif code == '*':
                    stack.append(num2 * num1)
                elif code == '/':
                    stack.append(num2 // num1)
            else:
                result = 'error'
                break
        else:
            stack.append(int(code))

    print(f'#{test_case} {result}')