infix = input()
stack = []

for txt in infix:
    if txt == '(':
        stack.append(txt)
    elif txt == ')':
        while stack and stack[-1] != '(':
            print(stack.pop(), end='')
        stack.pop()
    elif txt in '*/':
        while stack and stack[-1] in '*/':
            print(stack.pop(), end='')
        stack.append(txt)
    elif txt in '+-':
        while stack and stack[-1] != '(':
            print(stack.pop(), end='')
        stack.append(txt)
    else:
        print(txt, end='')

while stack:
    print(stack.pop(), end='')