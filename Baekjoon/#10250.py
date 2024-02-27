T = int(input())

for _ in range(T):
    H, W, N = map(int, input().split())
    chk = False
    num = 1
    for w in range(1, W+1):
        for h in range(1, H+1):
            if num == N:
                print(f'{h}{w:02d}')
                chk = True
                break
            num += 1
        if chk:
            break