import sys
N, M = map(int, sys.stdin.readline().split())
apdict = {}
for _ in range(N):
    add, pwd = sys.stdin.readline().split()
    apdict[add] = pwd

for _ in range(M):
    add = sys.stdin.readline().split()
    print(apdict[add[0]])