import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
m = int(input())
friend = [[] for _ in range(n+1)]
visit = [0] * (n+1)

for _ in range(m):
    a, b = map(int, input().split())
    friend[a].append(b)
    friend[b].append(a)

queue = deque()
queue.append(1)
visit[1] = 1

cnt = 0
depth = 0

while queue:
    depth += 1
    for _ in range(len(queue)):
        now = queue.popleft()
        for next in friend[now]:
            if not visit[next]:
                visit[next] = 1
                queue.append(next)
                cnt += 1
    if depth == 2:
        break

print(cnt)