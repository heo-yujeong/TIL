from collections import deque
T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    ipt = deque(enumerate(map(int, input().split())))

    cnt = 1
    while True:
        if ipt[0][1] == sorted(ipt, key=lambda x:-x[1])[0][1]:
            no, impo = ipt.popleft()
            if no == M:
                print(cnt)
                break
            else:
                cnt += 1
        else:
            ipt.rotate(-1)