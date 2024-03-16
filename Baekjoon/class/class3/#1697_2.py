from collections import deque

def bfs(X):
    queue = deque()
    queue.append(X)

    while queue:
        X = queue.popleft()

        for NX in [X+1, X-1, X*2]:
            if 0 <= NX < 100001 and not visit[NX]:
                if NX == K:
                    return visit[X] + 1
                visit[NX] = visit[X]+1
                queue.append(NX)

N, K = map(int, input().split())

if N == K:
    time = 0
elif N < K:
    visit = [0] * 100001
    time = bfs(N)
else:
    visit = [0] * 100001
    time = bfs(N)

print(time)