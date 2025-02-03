import sys
input = sys.stdin.readline

def dfs(i, j):
    if j == C-1:
        return True

    for d in [-1, 0, 1]:
        ni, nj = i + d, j + 1
        if 0 <= ni < R and 0 <= nj < C:
            if board[ni][nj] != 'x' and not visit[ni][nj]:
                visit[ni][nj] = 1
                if dfs(ni, nj):
                    return True
    return False


R, C = map(int, input().split())
board = [input() for _ in range(R)]
visit = [[0] * C for _ in range(R)]
cnt = 0

for i in range(R):
    if dfs(i, 0):
        cnt += 1

print(cnt)