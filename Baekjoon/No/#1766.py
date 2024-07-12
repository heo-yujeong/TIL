from collections import deque

N, M = map(int, input().split())
problem = [[] for _ in range(N+1)]

for _ in range(M):
    pre, after = map(int, input().split())
    problem[after].append(pre)

order = []
queue = deque()

for idx in range(1, N+1):
    if problem[idx] == []:
        queue.append(idx)

while queue:
    now = queue.popleft()
    if now not in order:
        order.append(now)
    
    for idx in range(1, N+1):
        pass