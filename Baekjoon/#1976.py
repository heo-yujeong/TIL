from collections import deque

def bfs(start):
    queue = deque()
    queue.append(start)
    visit[start] = 1

    while queue:
        start = queue.popleft()
        for next in range(1, N+1):
            if connect[start][next] and not visit[next]:
                visit[next] = 1
                queue.append(next)

N = int(input())
M = int(input())

connect = [[0]*(N+1)] + [[0]+list(map(int, input().split())) for _ in range(N)]
visit = [0] * (N+1)

plan = list(map(int, input().split()))

bfs(plan[0])

able = True
for p in plan:
    if not visit[p]:
        able = False
        break

if able:
    print('YES')
else:
    print('NO')