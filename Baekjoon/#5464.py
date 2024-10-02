import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
cost = [0] + [int(input()) for _ in range(N)]
weight = [0] + [int(input()) for _ in range(M)]

enter = [int(input()) for _ in range(2*M)]
queue = deque(enter)
possible = [-1] * (N+1)

result = 0
wait = deque()

while queue:
    car = queue.popleft()
    wait_queue = True

    if car > 0:
        for i in range(1, N+1):
            if possible[i] == -1:
                result += weight[car] * cost[i]
                possible[i] = car
                wait_queue = False
                break
        if wait_queue:
            wait.append(car)

    else:
        car = -car
        for i in range(1, N+1):
            if possible[i] == car:
                possible[i] = -1
                if len(wait) != 0:
                    car = wait.popleft()
                    result += weight[car] * cost[i]
                    possible[i] = car
                break

print(result)