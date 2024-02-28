N = int(input())
dot = [list(map(int, input().split())) for _ in range(N)]
dot.sort(key=lambda x:(x[1], x[0]))
for d in dot:
    print(*d)