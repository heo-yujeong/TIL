import sys
from collections import deque
input = sys.stdin.readline

def bfs(start, end):
    queue = deque()
    queue.append(start)
    visit[start] = 0

    while queue:
        now = queue.popleft()
        for next in range(now, N+1, numbers[now]):
            if visit[next] == -1:
                queue.append(next)
                visit[next] = visit[now] + 1
                if next == end:
                    return visit[next]

        for next in range(now, 0, -numbers[now]):
            if visit[next] == -1:
                queue.append(next)
                visit[next] = visit[now] + 1
                if next == end:
                    return visit[next]
    return -1

N = int(input())
numbers = [0] + list(map(int, input().split()))
a, b = map(int, input().split())
visit = [-1] * (N+1)

print(bfs(a, b))