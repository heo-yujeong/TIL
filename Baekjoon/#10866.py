import sys
from collections import deque
queue = deque()

N = int(sys.stdin.readline())
for _ in range(N):
    order = sys.stdin.readline().split()
    if order[0] == 'push_front':
        queue.appendleft(int(order[1]))
    elif order[0] == 'push_back':
        queue.append(int(order[1]))
    elif order[0] == 'pop_front':
        if queue:
            num = queue.popleft()
            print(num)
        else:
            print(-1)
    elif order[0] == 'pop_back':
        if queue:
            num = queue.pop()
            print(num)
        else:
            print(-1)
    elif order[0] == 'size':
        print(len(queue))
    elif order[0] == 'empty':
        if queue:
            print(0)
        else:
            print(1)
    elif order[0] == 'front':
        if queue:
            print(queue[0])
        else:
            print(-1)
    else:
        if queue:
            print(queue[-1])
        else:
            print(-1)