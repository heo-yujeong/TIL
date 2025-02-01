N = int(input())
rope = [int(input()) for _ in range(N)]
rope.sort()

result = []
for r in rope:
    result.append(r * N)
    N -= 1

print(max(result))