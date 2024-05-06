S = input()

stack = []
result = ''

for txt in S:
    if txt == '>':
        result += (''.join(stack))
        result += txt
        stack = []
    elif txt == '<' and stack:
        while stack:
            result += stack.pop()
        stack.append(txt)
    elif txt == ' ' and '<' not in stack:
        while stack:
            result += stack.pop()
        result += ' '
    else:
        stack.append(txt)

while stack:
    result += stack.pop()

print(result)