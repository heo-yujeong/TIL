from collections import deque

def bfs(start):
    queue = deque()
    queue.append(start)
    visit[start] = 1

    while queue:
        now = queue.popleft()
        if now == K:
            return
        for next in [now+1, now-1, now*2]:
            if 0 <= next < 100001 and (not visit[next] or visit[next] > visit[now]):
                if next == now * 2:
                    visit[next] = visit[now]
                else:
                    visit[next] = visit[now] + 1
                queue.append(next)

N, K = map(int, input().split())
visit = [0] * 100001

bfs(N)

print(visit[K]-1)