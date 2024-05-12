import sys
input = sys.stdin.readline

N = int(input())
S = [list(input().split()) for _ in range(N)]
L = list(input().split())

for l in L:
    isPossible = False
    for i in range(N):
        if len(S[i]) != 0:
            if l == S[i][0]:
                S[i].pop(0)
                isPossible = True
                break
    if not isPossible:
        break

left = 0
for s in S:
    left += len(s)

if isPossible and left == 0:
    print('Possible')
else:
    print('Impossible')