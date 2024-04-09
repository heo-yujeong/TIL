import sys
from collections import deque
input = sys.stdin.readline

def calc_time(time, start, graph):
    visit = [0] * (N+1)
    queue = deque()
    queue.append([time, start])

    while queue:
        time, now = queue.popleft()
        for t, next in graph[now]:
            if not visit[next] or visit[next] > visit[now] + t:
                visit[next] = time + t
                queue.append([time+t, next])

    visit[start] = 0
    return visit

N, M, X = map(int, input().split())
go = [[] * (N+1) for _ in range(N+1)]
come = [[] * (N+1) for _ in range(N+1)]

for _ in range(M):
    start, end, time = map(int, input().split())
    go[start].append([time, end])
    come[end].append([time, start])

go_times = calc_time(0, X, go)
come_times = calc_time(0, X, come)

result = [0] * (N+1)
for i in range(1, N+1):
    if i == X:
        continue
    else:
        result[i] = go_times[i] + come_times[i]

print(max(result))