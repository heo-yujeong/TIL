N = int(input())
numbers = list(map(int, input().split()))

stack = []
now = 1

for num in numbers:
    stack.append(num)

    while stack and stack[-1] == now:
        stack.pop()
        now += 1

if stack:
    print('Sad')
else:
    print('Nice')