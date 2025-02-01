import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    queue = deque()
    queue.append(start)

    while queue:
        now = queue.popleft()
        for next in graph[now]:
            if not parents[next]:
                parents[next] = now
                queue.append(next)

N = int(input())
graph = [[] for _ in range(N+1)]
for _ in range(N-1):
    node1, node2 = map(int, input().split())
    graph[node1].append(node2)
    graph[node2].append(node1)

parents = [0] * (N+1)
parents[1] = 1

bfs(1)

print(*parents[2:], sep='\n')