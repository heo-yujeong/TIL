import sys
from collections import deque
input = sys.stdin.readline

queue = deque()

N = int(input())
for _ in range(N):
    order = input().strip().split()
    cmd = order[0]

    if cmd == '1':
        queue.appendleft(int(order[1]))
    elif cmd == '2':
        queue.append(int(order[1]))
    elif cmd == '3':
        print(queue.popleft() if queue else -1)
    elif cmd == '4':
        print(queue.pop() if queue else -1)
    elif cmd == '5':
        print(len(queue))
    elif cmd == '6':
        print(0 if queue else 1)
    elif cmd == '7':
        print(queue[0] if queue else -1)
    elif cmd == '8':
        print(queue[-1] if queue else -1)