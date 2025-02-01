import sys
from collections import deque
input = sys.stdin.readline

def bfs(node):
    cnt = 1
    queue = deque()
    queue.append(node)
    visit = [0] * (N+1)
    visit[node] = 1

    while queue:
        now = queue.popleft()
        for next in graph[now]:
            if not visit[next]:
                visit[next] = 1
                queue.append(next)
                cnt += 1
    return cnt

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    A, B = map(int, input().split())
    graph[B].append(A)

result = []
for i in range(1, N+1):
    result.append(bfs(i))

for i in range(N):
    if result[i] == max(result):
        print(i+1, end=' ')