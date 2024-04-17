T = int(input())

for _ in range(T):
    N, M, W = map(int, input().split()) # 지점수 도로개수 웜홀개수
    load = [[] for _ in range(N)]
    hole = [[] for _ in range(N)]

    for _ in range(M):
        S, E, T = map(int, input().split())
        load[S].append((E, T))
        load[E].append((S, T))

    for _ in range(W):
        S, E, T = map(int, input().split())
        load[S].append((E, T))
        hole[S].append((E, T))

    time = [0] * (N+1)
    for i in range(1, N+1):
        visit = [0] * (N + 1)
        bfs(i)

