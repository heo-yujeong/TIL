import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(now):
    global cnt
    visit[now] = 1
    team.append(now)
    next = selected[now]

    if visit[next]:
        if next in team:
            cnt += len(team[team.index(next):])
    else:
        dfs(next)

T = int(input())

for _ in range(T):
    n = int(input())
    selected = [0] + list(map(int, input().split()))
    visit = [0] * (n+1)
    cnt = 0

    for i in range(1, n+1):
        if not visit[i]:
            team = []
            dfs(i)

    print(n - cnt)