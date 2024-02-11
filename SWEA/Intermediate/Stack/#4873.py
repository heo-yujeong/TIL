T = int(input())

for test_case in range(1, T+1):
    text = input()

    stack = []

    for char in text:
        if len(stack) == 0 or stack[-1] != char:
            stack.append(char)
        else:
            stack.pop()
            continue
    print(f'#{test_case} {len(stack)}')