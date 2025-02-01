def recur(x, y, size):
    if size == 3:
        star[x][y] = star[x+1][y-1] = star[x+1][y+1] = '*'
        for z in range(-2, 3):
            star[x+2][y-z] = '*'
    else:
        new_size = size // 2
        recur(x, y, new_size)
        recur(x+new_size, y-new_size, new_size)
        recur(x+new_size, y+new_size, new_size)

N = int(input())

star = [[' ']*2*N for _ in range(N)]
recur(0, N-1, N)

for s in star:
    print(''.join(s))