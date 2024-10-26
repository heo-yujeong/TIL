import sys
input = sys.stdin.readline

N, K = map(int, input().split())
medal = [list(map(int, input().split())) for _ in range(N)]
medal.sort(key= lambda x: (x[1], x[2], x[3]), reverse=True)
idx = 0

for i in range(N):
    if medal[i][0] == K:
        idx = i

for i in range(N):
    if medal[idx][1:] == medal[i][1:]:
        print(i+1)
        break