import sys
input = sys.stdin.readline

N, M = map(int, input().split())
move = [tuple(map(int, input().split())) for _ in range(M)]

result = list(range(N+1))
for U, V in reversed(move):
    result[U] = result[V]

print(*result[1:])