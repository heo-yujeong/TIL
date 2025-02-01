import sys
from collections import deque
input = sys.stdin.readline

def connect(n):
    cnt = 1
    hap = candies[n]

    queue = deque()
    queue.append(n)
    visit[n] = 1

    while queue:
        now = queue.popleft()

        for next in friend[now]:
            if not visit[next]:
                visit[next] = 1
                cnt += 1
                hap += candies[next]
                queue.append(next)
    return [cnt, hap]

N, M, K = map(int, input().split())
candies = [0] + list(map(int, input().split()))
friend = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    friend[a].append(b)
    friend[b].append(a)

group = []
visit = [0] * (N+1)
for i in range(1, N+1):
    if not visit[i]:
        group.append(connect(i))

d = [0] * (K+1)
for i in range(len(group)):
    cnt, hap = group[i]
    for j in range(K, cnt-1, -1):
        d[j] = max(d[j], d[j-cnt]+hap)

print(d[K-1])