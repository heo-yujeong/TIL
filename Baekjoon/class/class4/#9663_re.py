def backtrack(start):
    global cnt
    if start == N:
        cnt += 1
        return

    for i in range(N):
        if not used_c[i] and not used_up[start+i] and not used_down[(N-1)+start-i]:
            used_c[i] = 1
            used_up[start+i] = 1
            used_down[(N-1)+start-i] = 1
            backtrack(start+1)
            used_c[i] = 0
            used_up[start + i] = 0
            used_down[(N - 1) + start - i] = 0

N = int(input())
used_c = [0] * N
used_up = [0] * (2*(N-1)+1)
used_down = [0] * (2*(N-1)+1)

cnt = 0
backtrack(0)

print(cnt)