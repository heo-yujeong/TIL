import sys
from collections import deque
input = sys.stdin.readline

def bfs(now):
    global cnt
    queue = deque()
    queue.append(now)

    while queue:
        now = queue.popleft()
        if now == K:
            cnt += 1
        for next in [now+1, now-1, now*2]:
            if 0 <= next < 100001 and (not visit[next] or visit[next] == visit[now]+1):
                visit[next] = visit[now] + 1
                queue.append(next)

N, K = map(int, input().split())
visit = [0] * 100001

cnt = 0
if N == K:
    print(0)
    print(1)
else:
    bfs(N)

    print(visit[K])
    print(cnt)