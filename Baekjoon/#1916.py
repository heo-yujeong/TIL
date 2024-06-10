import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    queue = deque()
    queue.append([start, 0])
    visit[start] = 0

    while queue:
        now, cost = queue.popleft()
        if visit[now] < cost:
            continue
        for next, fee in city[now]:
            if visit[next] > cost + fee:
                visit[next] = cost + fee
                queue.append([next, cost+fee])

N = int(input())
M = int(input())
city = [[] for _ in range(N+1)]
for _ in range(M):
    a, b, fee = map(int, input().split())
    city[a].append([b, fee])

start, end = map(int, input().split())

visit = [100000*N] * (N+1)

bfs(start)

print(visit[end])