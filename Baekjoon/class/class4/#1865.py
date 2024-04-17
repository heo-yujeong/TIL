import sys
input = sys.stdin.readline

def times():
    time[1] = 0
    for i in range(N):
        for now in range(1, N+1):
            for next, t in load[now]:
                if time[next] > time[now] + t:
                    time[next] = time[now] + t
                    if i == N-1:
                        return True
    return False

T = int(input())

for _ in range(T):
    N, M, W = map(int, input().split())
    load = [[] for _ in range(N+1)]

    for _ in range(M):
        S, E, T = map(int, input().split())
        load[S].append((E, T))
        load[E].append((S, T))

    for _ in range(W):
        S, E, T = map(int, input().split())
        load[S].append((E, -T))

    time = [10001] * (N + 1)
    able = times()

    if able:
        print('YES')
    else:
        print('NO')