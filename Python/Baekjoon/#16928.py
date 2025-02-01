from collections import deque

def bfs(start):
    queue = deque()
    queue.append(start)

    while queue:
        start = queue.popleft()
        for i in range(1, 7):
            next = start + i
            if 1 <= next <= 100:
                if next in move:
                    next = move[next]
                if not visit[next]:
                    visit[next] = visit[start] + 1
                    queue.append(next)

N, M = map(int, input().split())
move = {}

for _ in range(N+M):
    from_, to_ = map(int, input().split())
    move[from_] = to_
visit = [0] * 101

bfs(1)

print(visit[100])