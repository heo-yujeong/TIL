def cut_paper(x, y, N):
    global num_w, num_b
    col = paper[x][y]
    for i in range(x, x+N):
        for j in range(y, y+N):
            if paper[i][j] != col:
                cut_paper(x, y, N//2)
                cut_paper(x, y+N//2, N//2)
                cut_paper(x+N//2, y, N//2)
                cut_paper(x+N//2, y+N//2, N//2)
                return
    if col == 0:
        num_w += 1
    else:
        num_b += 1

N = int(input())
paper = [list(map(int, input().split())) for _ in range(N)]

num_w = num_b = 0

cut_paper(0, 0, N)

print(num_w)
print(num_b)