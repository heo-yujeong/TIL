N, M = map(int, input().split())
castle = [input() for _ in range(N)]

col = set()
row = set()

for i in range(N):
    for j in range(M):
        if castle[i][j] == 'X':
            col.add(i)
            row.add(j)

print(max(N-len(col), M-len(row)))