import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
S = [deque(input().split()) for _ in range(N)]
L = deque(input().split())

while L:
    l = L.popleft()
    isPossible = False
    for s in S:
        if s and s[0] == l:
            s.popleft()
            if not s:
                S.remove(s)
            isPossible = True
            break
    if not isPossible:
        break

if isPossible and not S:
    print('Possible')
else:
    print('Impossible')