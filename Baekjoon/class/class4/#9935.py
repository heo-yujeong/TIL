import sys
input = sys.stdin.readline

string = input().strip()
search = input().strip()
search_len = len(search)

stack = []

for s in string:
    stack.append(s)
    if len(stack) >= search_len and ''.join(stack[-search_len:]) == search:
        for _ in range(search_len):
            stack.pop()

if stack:
    print(''.join(stack))
else:
    print('FRULA')