from collections import deque

def bfs(now):
    queue = deque()
    queue.append(now)

    while queue:
        now = queue.popleft()
        for next in [now+1, now-1, now*2]:
            if 0 <= next < 30 and not visit[next]:
                visit[next] = visit[now] + 1
                if next == K:
                    return
                queue.append(next)

N, K = map(int, input().split())
visit = [0] * 30

visit[N] = 1
bfs(N)

print(visit[K]-1)