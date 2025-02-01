import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
position = list(map(int, input().split()))
queue = deque(range(1, N+1))

cnt = 0

for i in position:
    while True:
        if queue[0] == i:
            queue.popleft()
            break
        else:
            if queue.index(i) <= len(queue)//2:
                queue.rotate(-1)
                cnt += 1
            else:
                queue.rotate(1)
                cnt += 1

print(cnt)