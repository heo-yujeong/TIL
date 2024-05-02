import sys
input = sys.stdin.readline

def backtracking(index):
    global max_cnt
    if index == n:
        cnt = 0
        for i in range(n):
            if arr[i][0] <= 0:
                cnt += 1
        max_cnt = max(max_cnt, cnt)
        return

    if arr[index][0] <= 0:
        backtracking(index + 1)
        return

    check = True
    for i in range(n):
        if i == index:
            continue
        if arr[i][0] > 0:
            check = False
            break

    if check:
        max_cnt = max(max_cnt, n - 1)
        return

    for i in range(n):
        if i == index or arr[i][0] <= 0:
            continue
        arr[index][0] -= arr[i][1]
        arr[i][0] -= arr[index][1]
        backtracking(index + 1)
        arr[index][0] += arr[i][1]
        arr[i][0] += arr[index][1]


n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

max_cnt = 0
backtracking(0)
print(max_cnt)