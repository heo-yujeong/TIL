import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N, K = map(int, input().split())
    build_time = list(map(int, input().split()))
    rules = [[] for _ in range(N)]
    indegree = [0] * N
    times = [0] * N

    for _ in range(K):
        X, Y = map(int, input().split())
        X, Y = X-1, Y-1
        rules[X].append(Y)
        indegree[Y] += 1

    W = int(input()) - 1

    queue = deque()

    for i in range(N):
        if not indegree[i]:
            queue.append(i)
            times[i] = build_time[i]

    while queue:
        now = queue.popleft()

        for next in rules[now]:
            indegree[next] -= 1
            times[next] = max(times[next], times[now]+build_time[next])
            if not indegree[next]:
                queue.append(next)

    print(times[W])