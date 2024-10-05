import sys
input = sys.stdin.readline

def dfs(y, x):
    if x < 0 or x >= N or y < 0 or y >= N or visit[y][x]:
        return

    if board[y][x] == -1:
        visit[y][x] = 1
        return

    visit[y][x] = 1

    dfs(y, x+board[y][x])
    dfs(y+board[y][x], x)

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
visit = [[0]*N for _ in range(N)]
dfs(0, 0)

if visit[-1][-1]:
    print('HaruHaru')
else:
    print('Hing')