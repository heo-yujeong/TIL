import sys

N, M = map(int, sys.stdin.readline().split())
pok_dict = {}
for idx in range(1, N+1):
    name = sys.stdin.readline().rstrip()
    pok_dict[str(idx)] = name
    pok_dict[name] = idx

for _ in range(M):
    print(pok_dict.get(sys.stdin.readline().rstrip()))