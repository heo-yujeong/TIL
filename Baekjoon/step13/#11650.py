N = int(input())
dot = [list(map(int, input().split())) for _ in range(N)]
dot.sort(key=lambda x:(x[0], x[1]))
for d in dot:
    print(*d)