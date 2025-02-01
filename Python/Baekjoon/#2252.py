import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
student = [[] for _ in range(N+1)]
indegree = [0] * (N+1)

for _ in range(M):
    A, B = map(int, input().split())
    student[A].append(B)
    indegree[B] += 1

queue = deque()
order = []

for i in range(1, N+1):
    if not indegree[i]:
        queue.append(i)

while queue:
    now = queue.popleft()
    order.append(now)

    for next in student[now]:
        indegree[next] -= 1
        if not indegree[next]:
            queue.append(next)

print(*order)