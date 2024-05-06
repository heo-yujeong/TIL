import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())
Ai = deque(map(int, input().split()))
robot = deque([0] * N)

step = 0

while True:
    step += 1

    Ai.rotate(1)
    robot.rotate(1)
    robot[N-1] = 0

    for i in range(N-2, -1, -1):
        if Ai[i+1] > 0 and robot[i+1] == 0 and robot[i] == 1:
            robot[i+1] = 1
            robot[i] = 0
            Ai[i+1] -= 1
    robot[N-1] = 0

    if Ai[0] >= 1 and robot[0] == 0:
        robot[0] = 1
        Ai[0] -= 1

    if Ai.count(0) >= K:
        break

print(step)