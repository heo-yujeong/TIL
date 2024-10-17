N, L = map(int, input().split())
pipe = list(map(int, input().split()))
pipe.sort()

start = pipe[0]
cnt = 1

for next in pipe[1:]:
    if next in range(start, start+L):
        continue
    else:
        start = next
        cnt += 1

print(cnt)