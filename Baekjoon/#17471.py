import sys
from itertools import product
from collections import deque
input = sys.stdin.readline

def bfs(group):
    queue = deque()
    queue.append(group[0])
    visit = set([group[0]])
    hap = 0

    while queue:
        now = queue.popleft()
        hap += num_of_peo[now-1]
        for next in graph[now]:
            if next not in visit and next in group:
                queue.append(next)
                visit.add(next)
    return hap, len(visit)

N = int(input())
num_of_peo = list(map(int, input().split()))
graph = [[] for _ in range(N+1)]
result = sum(num_of_peo)

for i in range(1, N+1):
    cnt, *lst = map(int, input().split())
    graph[i].extend(lst)

for lst in product([1, 2], repeat=N):
    if lst.count(1) == N or lst.count(2) == N:
        continue
    else:
        group1, group2 = [], []
        for i in range(len(lst)):
            if lst[i] == 1:
                group1.append(i+1)
            else:
                group2.append(i+1)
        hap_peo1, visit1 = bfs(group1)
        hap_peo2, visit2 = bfs(group2)
        if visit1 + visit2 == N:
            result = min(result, abs(hap_peo1-hap_peo2))

if result == sum(num_of_peo):
    print(-1)
else:
    print(result)