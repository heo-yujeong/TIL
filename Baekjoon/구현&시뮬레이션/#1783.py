N, M = map(int, input().split())

if N == 1:
    cnt = 1
elif N == 2:
    cnt = min(4, ((M-1)//2+1))
elif M < 7:
    cnt = min(4, M)
else:
    cnt = (2+(M-5))+1

print(cnt)