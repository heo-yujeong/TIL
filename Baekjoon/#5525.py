import sys

def KMP(txt, pat):
    global cnt
    N = len(txt)
    M = len(pat)
    lps = [0] * (M+1)

    j = 0
    lps[0] = -1
    for i in range(1, M):
        lps[i] = j
        if pat[i] == pat[j]:
            j += 1
        else:
            j = 0
    lps[M] = j

    i = j = 0
    while i < N and  j <= M:
        if j == -1 or txt[i] == pat[j]:
            i += 1
            j += 1
        else:
            j = lps[j]
        if j == M:
            cnt += 1
            j = lps[j]

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
S = sys.stdin.readline()

Pn = 'IO' * N + 'I'
len_Pn = len(Pn)

cnt = 0
KMP(S, Pn)
print(cnt)