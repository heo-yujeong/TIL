from collections import deque

def bfs(X):
    queue = deque()
    queue.append(X)

    while queue:
        X = queue.popleft()

        if 0 <= X - 1 < len(visit) and not visit[X - 1]:
            if X - 1 == K:
                return visit[X] + 1
            visit[X - 1] = visit[X] + 1
            queue.append(X - 1)
        if 0 <= X + 1 < len(visit) and not visit[X + 1]:
            if X + 1 == K:
                return visit[X] + 1
            visit[X + 1] = visit[X] + 1
            queue.append(X + 1)
        if 0 <= X * 2 < len(visit) and not visit[X * 2]:
            if X * 2 == K:
                return visit[X] + 1
            visit[X * 2] = visit[X] + 1
            queue.append(X * 2)

N, K = map(int, input().split())

if N == K:
    time = 0
elif N < K:
    visit = [0] * (K * 2)
    time = bfs(N)
else:
    visit = [0] * (N * 2)
    time = bfs(N)

print(time)