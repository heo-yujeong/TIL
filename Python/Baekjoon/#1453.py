pc = {}
N = int(input())
wants = list(map(int, input().split()))
cnt = 0

for i in range(N):
    if pc.get(wants[i]):
        cnt += 1
    else:
        pc[wants[i]] = wants[i]

print(cnt)