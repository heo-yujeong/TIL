while True:
    char = input()
    if char[0] == '.':
        break
    stack = []
    result = 'yes'

    for txt in char:
        if txt == '.':
            break
        elif txt in '([)]':
            if txt in '([':
                stack.append(txt)
            elif stack and ((stack[-1] =='(' and txt == ')') or (stack[-1] == '[' and txt == ']')):
                stack.pop()
            else:
                result = 'no'
                break
        else:
            continue

    if stack:
        result = 'no'

    print(result)