import sys
input = sys.stdin.readline

def divide(y, x, N):
    color = matrix[y][x]

    for i in range(y, y+N):
        for j in range(x, x+N):
            if color != matrix[i][j]:
                for a in range(3):
                    for b in range(3):
                        divide(y+(N//3)*a, x+(N//3)*b, N//3)
                return

    if color == 1:
        cnt.append(1)
    elif color == -1:
        cnt.append(-1)
    else:
        cnt.append(0)

N = int(input())
matrix = [list(map(int, input().split())) for _ in range(N)]
cnt = []

divide(0, 0, N)
print(cnt.count(-1), cnt.count(0), cnt.count(1), sep='\n')