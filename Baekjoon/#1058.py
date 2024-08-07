N = int(input())
friends = [list(input()) for _ in range(N)]
connect = [[0]*N for _ in range(N)]

for k in range(N):
    for i in range(N):
        for j in range(N):
            if i == j:
                continue
            if friends[i][j] == 'Y' or (friends[i][k] == friends[k][j] == 'Y'):
                connect[i][j] = 1

result = 0
for con in connect:
    result = max(result, sum(con))

print(result)