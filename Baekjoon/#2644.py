import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    queue = deque()
    queue.append(start)
    visit[start] = 0

    while queue:
        now = queue.popleft()
        for next in graph[now]:
            if visit[next] == -1:
                visit[next] = visit[now] + 1
                queue.append(next)

n = int(input())
one, other = map(int, input().split())
graph = [[] for _ in range(n+1)]
visit = [-1] * (n+1)
m = int(input())
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

bfs(one)
print(visit[other])