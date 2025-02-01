import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
stage = [[] for _ in range(N+1)]
indgree = [0] * (N+1)

for _ in range(M):
    order = list(map(int, input().split()))
    for i in range(1, order[0]):
        stage[order[i]].append(order[i+1])
        indgree[order[i+1]] += 1

queue = deque()
result = []

for i in range(1, N+1):
    if indgree[i] == 0:
        queue.append(i)

while queue:
    now = queue.popleft()
    result.append(now)

    for next in stage[now]:
        indgree[next] -= 1

        if indgree[next] == 0:
            queue.append(next)

if len(result) != N:
    print(0)
else:
    print(*result, sep='\n')