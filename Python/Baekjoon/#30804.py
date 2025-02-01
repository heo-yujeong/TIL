import sys
input = sys.stdin.readline

N = int(input())
S = list(map(int, input().split()))

cnt = [0] * 10
kind = 0
max_len = 0

start = 0

for end in range(N):
    if cnt[S[end]] == 0:
        kind += 1
    cnt[S[end]] += 1

    while kind > 2:
        cnt[S[start]] -= 1
        if cnt[S[start]] == 0:
            kind -= 1
        start += 1

    max_len = max(max_len, end-start+1)

print(max_len)