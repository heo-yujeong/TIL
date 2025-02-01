import sys
input = sys.stdin.readline

N, B, W = map(int, input().split())
stones = input()

left = 0
w_cnt, b_cnt = 0, 0
result = 0

for right in range(N):
    if stones[right] == 'W':
        w_cnt += 1
    else:
        b_cnt += 1

    while b_cnt > B:
        if stones[left] == 'W':
            w_cnt -= 1
        else:
            b_cnt -= 1
        left += 1

    if w_cnt >= W:
        result = max(result, right-left+1)

print(result)