dx = [0, 1]
dy = [1, 0]

def check(x, y, sum):
    global result

    if x == N-1 and y == N-1:
        if result > sum:
            result = sum
        return

    if sum > result:
        return

    for i in range(2):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < N:
            check(nx, ny, sum + arr[nx][ny])

T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]

    result = 10 * N * N
    check(0, 0, arr[0][0])

    print(f'#{test_case} {result}')