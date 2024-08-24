import sys
input = sys.stdin.readline

left = list(input().strip())
right = []
M = int(input())

for _ in range(M):
    order = input().split()

    if order[0] == 'L' and left:
        right.append(left.pop())
    elif order[0] == 'D' and right:
        left.append(right.pop())
    elif order[0] == 'P':
        left.append(order[1])
    elif order[0] == 'B' and left:
        left.pop()

print(''.join(left + list(reversed(right))))