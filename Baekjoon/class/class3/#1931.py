N = int(input())
order = [list(map(int, input().split())) for _ in range(N)]
order.sort(key=lambda x:(x[1], x[0]))

cnt = 0
end_time = 0

for s, e in order:
    if s >= end_time:
        cnt += 1
        end_time = e

print(cnt)