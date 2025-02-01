N = int(input())
file = [list(input()) for _ in range(N)]

result = file[0]

for i in range(N):
    for j in range(len(result)):
        if result[j] == file[i][j]:
            continue
        else:
            result[j] = '?'

print(''.join(result))