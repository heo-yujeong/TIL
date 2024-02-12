def dfs(start, sum):
    global result
    if sum < result:
        if 0 not in visited[1:]:
            result = min(result, sum+arr[start][0])
            return
        for next in range(1, N):
            if arr[start][next] != 0 and visited[next] == 0:
                visited[next] = 1
                dfs(next, sum + arr[start][next])
                visited[next] = 0


T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]

    result = 100 * 100

    for i in range(1, N):
        visited = [0] * N
        visited[i] = 1
        dfs(i, arr[0][i])

    print(f'#{test_case} {result}')