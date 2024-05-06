import sys
input = sys.stdin.readline

N = int(input())
building = list(map(int, input().split()))
max_cnt = 0

for i in range(N):
    cnt = N - 1
    for j in range(i):
        for k in range(j+1, i):
            if building[k] - building[j] >= (((building[i] - building[j]) / (i - j)) * (k - j)):
                cnt -= 1
                break
    for j in range(i+1, N):
        for k in range(i+1, j):
            if building[k] - building[i] >= (((building[j] - building[i]) / (j - i)) * (k - i)):
                cnt -= 1
                break
    max_cnt = max(max_cnt, cnt)

print(max_cnt)