from collections import deque
import sys

T = int(input())
for _ in range(T):
    func = sys.stdin.readline().strip()
    n = int(sys.stdin.readline())
    queue = deque(sys.stdin.readline().strip()[1:-1].split(','))
    if n == 0:
        queue = deque()
    cnt = 0
    for f in func:
        if f == 'R':
            cnt += 1
        else:
            if queue:
                if cnt % 2 == 0:
                    queue.popleft()
                else:
                    queue.pop()
            else:
                print('error')
                break
    else:
        if cnt % 2 == 0:
            print('[' + ','.join(map(str, queue)) + ']')
        else:
            queue.reverse()
            print('[' + ','.join(map(str, queue)) + ']')